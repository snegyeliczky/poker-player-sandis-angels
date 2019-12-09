package org.leanpoker.player.FindCards.bet;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.leanpoker.player.FindCards.FindCards;

import java.util.ArrayList;
import java.util.stream.Collectors;

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

    public int compareCards(){
        ArrayList<String> myCards = getMyCards();
        ArrayList<String> tableCards = getTableCards();
        ArrayList<String> sameElements = (ArrayList<String>) myCards.stream()
                .filter(tableCards::contains)
                .collect(Collectors
                        .toList());
        return sameElements.size();
    }

}