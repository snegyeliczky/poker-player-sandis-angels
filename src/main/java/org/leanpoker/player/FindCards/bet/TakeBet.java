package org.leanpoker.player.FindCards.bet;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.leanpoker.player.FindCards.FindCards;

import java.util.ArrayList;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.List;

public class TakeBet extends FindCards {

    public TakeBet(JsonElement request) {
        super(request);
    }

    private ArrayList<String> yourCard(String type, JsonArray cardPack){
        ArrayList<String> ranks = new ArrayList();
        for (JsonElement o :cardPack){
            String value =  o.getAsJsonObject().get(type).getAsString();
            ranks.add(value);
            String card = type+"-"+value;

    }
        return ranks;
    }

    public ArrayList<String> getMyCards(){
        return yourCard("rank", this.yourCards);
    }
    public ArrayList<String> getTableCards(){
        return yourCard("rank", this.cardsOnTable);
    }
    public ArrayList<String> getMyCardsSuit(){
        return yourCard("suit", this.yourCards);
    }
    public ArrayList<String> getTableCardsSuit(){
        return yourCard("suit", this.cardsOnTable);
    }

    private int getValueOfCards(){
        ArrayList<String> inHand = getMyCards();
        ArrayList<String> onTable = getTableCards();
        int pairs=0;
        if (inHand.get(0).equals(inHand.get(1))){
            pairs+=1;
            for (String cardOnTable : onTable ){
                if (cardOnTable.equals(inHand.get(0))){
                    pairs+=1;
                }
            }
        } else {
            for (int i = 0; i < inHand.size(); i++) {
               String myCard  =  inHand.get(i);
                for (int j = 0; j < onTable.size(); j++) {
                    if (myCard.equals(onTable.get(j))){
                        pairs++;
                    }
                }
            }
        }
        return pairs;
    }

    public int getBetValue(){
        if (this.cardsOnTable().size()==0){
            return holdBet();
        }
        switch (getValueOfCards()){
            case 0:
                return 0;
            case 1:
                return (int) ((holdBet()+minimumRaise()));
            case 2:
                return (int) ((holdBet()+minimumRaise())*1.2);
            case 3:
                return (int) ((holdBet()+minimumRaise())*1.4);
            case 4:
                return (int) ((holdBet()+minimumRaise()*1.5));

        }
        return 0;
    }


    public int compareCards(){
        ArrayList<String> myCards = getMyCards();
        ArrayList<String> tableCards = getTableCards();
        ArrayList<String> sameElements = (ArrayList<String>) myCards.stream()
                .filter(tableCards::contains)
                .collect(Collectors
                        .toList());
        return sameElements.size();
    }

    public int sameValue() {
        if (this.yourCards.get(0).getAsJsonObject().get("rank") == this.yourCards.get(1).getAsJsonObject().get("rank")) {
            return 10;
        }

        return 0;
    }

    public int holdBet() {
        int biggestBet = request.getAsJsonObject().get("current_buy_in").getAsInt();
        int ourLastBet = 0;
        JsonArray jsonArray= request.getAsJsonObject().get("players").getAsJsonArray();
        for (JsonElement jsonElement : jsonArray){
            if (jsonElement.getAsJsonObject().get("id").toString().equals(request.getAsJsonObject().get("in_action").getAsString())){
                ourLastBet = jsonElement.getAsJsonObject().get("bet").getAsInt();
                System.out.println(ourLastBet);
            }
        }
        return  biggestBet - ourLastBet;
    }




}
