package org.leanpoker.player;


import com.google.gson.JsonElement;
import org.leanpoker.player.FindCards.bet.TakeBet;

public class Player {

    static final String VERSION = "All in hhhh";

    public static int betRequest(JsonElement request) {
        TakeBet takeBet = new TakeBet(request);
        int bet = takeBet.getBetValue();
        if (takeBet.getAllSuits()){
            bet = takeBet.allIn();
        }
        return bet;
    }

    public static void showdown(JsonElement game) {
    }
}
