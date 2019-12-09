package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import org.leanpoker.player.FindCards.FindCards;
import org.leanpoker.player.FindCards.bet.TakeBet;

public class Player {

    static final String VERSION = "Bet one";

    public static int betRequest(JsonElement request) {
        TakeBet takeBet = new TakeBet(request);
        int bet = takeBet.getBetValue();
        System.out.println(bet);
        return bet;
    }

    public static void showdown(JsonElement game) {
    }
}
