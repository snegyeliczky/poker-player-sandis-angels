package org.leanpoker.player.FindCards.bet;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.leanpoker.player.FindCards.FindCards;

public class TakeBet extends FindCards {

    public TakeBet(JsonElement request) {
        super(request);
    }

    public int bet(){
        for (JsonElement o :this.yourCards){
            String value =  o.getAsJsonObject().get("rank").getAsString();
            String type  =  o.getAsJsonObject().get("suit").getAsString();
            System.out.println(type+value);
    }
        return 0;
    }


}
