package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.Map;

public class Player {

    static final String VERSION = "Sandis Angels 1.0";

    public static int betRequest(JsonElement request) {
        System.out.println("in ");
        JsonArray jsonArray= request.getAsJsonObject().get("players").getAsJsonArray();
        JsonElement je = jsonArray.get(1);
        JsonArray cards=je.getAsJsonObject().get("hole_cards").getAsJsonArray();

        System.out.println(cards.toString());

        return 0;
    }

    public static void showdown(JsonElement game) {
    }
}
