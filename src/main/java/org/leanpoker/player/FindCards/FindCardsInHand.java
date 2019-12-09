package org.leanpoker.player.FindCards;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class FindCardsInHand {

    private JsonElement request;
    private  JsonArray yourCards;

    public FindCardsInHand(JsonElement request) {
        this.request = request;
        this.yourCards = findCards();
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

    public JsonArray getYourCards() {
        return yourCards;
    }
}
