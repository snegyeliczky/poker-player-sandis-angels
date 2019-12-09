package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import org.leanpoker.player.FindCards.FindCardsInHand;

import java.util.Map;

public class Player {

    static final String VERSION = "Sandis Angels 1.0";

    public static int betRequest(JsonElement request) {
        FindCardsInHand findCardsInHand = new FindCardsInHand(request);
        JsonArray cards = findCardsInHand.getYourCards();
        System.out.println(cards);

        return 0;
    }

    public static void showdown(JsonElement game) {
    }
}
