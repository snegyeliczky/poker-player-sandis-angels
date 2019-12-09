package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import org.leanpoker.player.FindCards.FindCards;
import org.leanpoker.player.FindCards.bet.TakeBet;

public class Player {

    static final String VERSION = "Sandis Angels 1.0";

    public static int betRequest(JsonElement request) {
        TakeBet takeBet = new TakeBet(request);

        int bet = 0;
        bet = request.getAsJsonObject().get("current_buy_in").getAsInt()+5;
        bet += takeBet.bet();
        bet += takeBet.sameValue();

        FindCards findCards = new FindCards(request);
        JsonArray cards = findCards.getYourCards();
        JsonArray cardsOnTable = findCards.cardsOnTable();

        System.out.println("On Table: "+cardsOnTable);
        System.out.println("In your hands: "+cards);
        System.out.println(findCards.getBuyIn());

        return bet;
    }

    public static void showdown(JsonElement game) {
    }
}
