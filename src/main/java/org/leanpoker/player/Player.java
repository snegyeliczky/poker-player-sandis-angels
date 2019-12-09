package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Map;

public class Player {

    static final String VERSION = "Sandis Angels 1.0";

    public static int betRequest(JsonElement request) {
        JsonObject asJsonObject = request.getAsJsonObject();
        JsonArray jsonArray = asJsonObject.get("hole_cards").getAsJsonArray();
        if (jsonArray.get(1).toString().equals("10")) {
            return 100;
        }
        return 0;
    }

    public static void showdown(JsonElement game) {
    }
}
