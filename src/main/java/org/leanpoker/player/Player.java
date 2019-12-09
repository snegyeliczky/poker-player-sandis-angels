package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import org.leanpoker.player.FindCards.FindCards;
import org.leanpoker.player.FindCards.bet.TakeBet;

public class Player {

    static final String VERSION = "Sandis Angels 1.0";

    public static int betRequest(JsonElement request) {
        TakeBet takeBet = new TakeBet(request);
        return takeBet.getBetValue();
    }

    public static void showdown(JsonElement game) {
    }
}
