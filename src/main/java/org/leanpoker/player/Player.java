package org.leanpoker.player;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.Map;
import java.util.logging.Logger;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {
        String list = request.getAsJsonObject().get("bet_index").getAsJsonArray().toString();
        Logger LOGGER = Logger.getLogger(list);
        return 0;
    }

    public static void showdown(JsonElement game) {
    }
}
