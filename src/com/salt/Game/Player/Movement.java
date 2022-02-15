package com.salt.Game.Player;

import static com.salt.Game.Player.Player.*;
import static com.salt.Game.World.Map.*;
import static com.salt.Game.Function.Functions.*;

public class Movement {
    public static void w() {
        if (dy <= 8 && py + 1 < 8) {
            if (dy == 8 && !map[px][py + 1].isBorder()) {
                dy = 0;
                py++;
                player.toBottom();
            } else if (py >= 6 && dy == 7) {
                Void();
            } else {
                if (!map[px][py].chunk[dx][dy + 1].isTaken()) {
                    dy++;
                    player.up();
                }
            }
        }
    }

    public static void a() {
        if (dx >= 0 && px - 1 >= 0) {
            if (dx == 0 && !map[px - 1][py].isBorder()) {
                dx = 15;
                px--;
                player.toRight();
            } else if (px <= 0 && dx == 0) {

            } else {
                if (!map[px][py].chunk[dx - 1][dy].isTaken()) {
                    dx--;
                    player.left();
                }
            }
        }
    }

    public static void s() {
        if (dy >= 0 && py >= 0) {
            if (dy == 0 && !map[px][py - 1].isBorder()) {
                dy = 8;
                py--;
                player.toTop();
            } else if (py <= 0 && dy == 0) {

            } else {
                if (!map[px][py].chunk[dx][dy - 1].isTaken()) {
                    dy--;
                    player.down();
                }
            }
        }
    }

    public static void d() {
        if (dx <= 15 && px + 1 < 8) {
            if (dx == 15 && !map[px + 1][py].isBorder()) {
                dx = 0;
                px++;
                player.toLeft();
            } else if (px >= 6 && dx == 14) {
                Void();
            } else {
                if (!map[px][py].chunk[dx + 1][dy].isTaken()) {
                    dx++;
                    player.right();
                }
            }
        }
    }
}
