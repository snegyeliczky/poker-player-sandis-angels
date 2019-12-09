package org.leanpoker.player.Test;

import com.google.gson.JsonElement;
import org.leanpoker.player.Player;

public class Main {
    public static void main(String[] args) {
        MainTest mainTest= new MainTest();
        JsonElement jsonElement =  mainTest.jsonElement;
        Player.betRequest(jsonElement);
    }
}
