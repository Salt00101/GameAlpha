package com.salt.Game;

import com.salt.Game.Battle.Battle;
import com.salt.Game.Render.Window.Window;

public class Game {
    public static void main(String[] args) throws InterruptedException {
        new Window().run();
        // new Battle("Frog", 2, 1, true).battleScene();
        System.out.println(Math.cos(69*Math.PI));
    }
}