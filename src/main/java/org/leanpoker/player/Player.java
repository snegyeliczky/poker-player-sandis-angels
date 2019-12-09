package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import org.leanpoker.player.FindCards.FindCards;
import org.leanpoker.player.FindCards.bet.TakeBet;

public class Player {

    static final String VERSION = "Bet one";

    public static int betRequest(JsonElement request) {
        TakeBet takeBet = new TakeBet(request);
        System.out.println("minraise" + takeBet.minimumRaise());
        System.out.println("holdbet: " + takeBet.holdBet());
        return takeBet.getBetValue();
    }

    public static void showdown(JsonElement game) {
    }
}
