package org.leanpoker.player;

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
        JsonArray jsonArray= request.getAsJsonObject().get("players").getAsJsonArray();
        JsonElement je = jsonArray.get(1);
        JsonArray cards=je.getAsJsonObject().get("hole_cards").getAsJsonArray();
        return cards;
    }
}
