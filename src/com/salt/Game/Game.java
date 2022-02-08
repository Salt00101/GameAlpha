package com.salt.Game;

import com.salt.Game.Player.Player;
import com.salt.Game.Render.Window.Window;
import com.salt.Game.World.Chunk;

import static com.salt.Game.Player.Player.*;
import static com.salt.Game.Player.Player.dy;
import static com.salt.Game.World.Map.*;
import com.salt.Game.World.Tile;

import java.util.ArrayList;

public class Game {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                map[i][j] = new Chunk(new Tile[8][8]);
            }
        }

        Tile[][] t = new Tile[16][9];

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 9; j++) {
                t[i][j] = new Tile("" , false, false, true, -1, -1);
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                map[i][j] = new Chunk(t);
            }
        }

        for (int i = 0; i < 8; i++) {
            map[0][i].setBorder(true);
        }
        for (int i = 0; i < 8; i++) {
            map[7][i].setBorder(true);
        }
        for (int i = 0; i < 8; i++) {
            map[i][0].setBorder(true);
        }
        for (int i = 0; i < 8; i++) {
            map[i][7].setBorder(true);
        }

        Player.dx = 8;
        Player.dy = 4;
        Player.px = 2;
        Player.py = 2;

        map[2][2].chunk[8][5].setTaken(true);

        new Window().run();
    }
}