package org.leanpoker.player.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.Arrays;

public class PairSearch {
   private JsonElement gameState;

    public PairSearch(JsonElement gameState) {
        this.gameState = gameState;
    }

    public void parseJson(){
        JsonArray jsonArray = gameState.getAsJsonArray();
        System.out.println(Arrays.toString(new JsonArray[]{jsonArray}));

    }
}
