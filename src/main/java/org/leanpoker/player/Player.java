package org.leanpoker.player;


import com.google.gson.JsonElement;
import org.leanpoker.player.FindCards.bet.TakeBet;

public class Player {

    static final String VERSION = "All in line out";

    public static int betRequest(JsonElement request) {
        TakeBet takeBet = new TakeBet(request);
        int bet = takeBet.getBetValue();
        return bet;
    }

    public static void showdown(JsonElement game) {
    }
}
