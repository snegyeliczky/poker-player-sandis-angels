package org.leanpoker.player.FindCards;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class FindCards {

    protected JsonElement request;
    protected  JsonArray yourCards;
    protected  JsonArray cardsOnTable;
    protected  int buyIn;


    public FindCards(JsonElement request) {
        this.request = request;
        this.yourCards = findCards();
        this.cardsOnTable = cardsOnTable();
        this.buyIn=currentBuyIn();
    }

    public JsonArray findCards(){
        System.out.println("in ");
        JsonArray jsonArray= request.getAsJsonObject().get("players").getAsJsonArray();
        for (JsonElement jsonElement : jsonArray){
            if (jsonElement.getAsJsonObject().get("name").toString().equals("\"Sandis Angels\"")){
                System.out.println("Name Finded");
                JsonArray cards= jsonElement.getAsJsonObject().get("hole_cards").getAsJsonArray();
                return cards;
            }
        }
        return null;
    }

    public JsonArray cardsOnTable(){
        JsonArray jsonArray= request.getAsJsonObject().get("community_cards").getAsJsonArray();
        return jsonArray;
    }

    public int currentBuyIn(){
        int bet= request.getAsJsonObject().get("current_buy_in").getAsInt();
        return bet;
    }

    public JsonArray getYourCards() {
        return yourCards;
    }

    public int getBuyIn() {
        return buyIn;
    }

    public int minimumRaise(){
        int minRaise= request.getAsJsonObject().get("minimum_raise").getAsInt();
        return minRaise;
    }
}