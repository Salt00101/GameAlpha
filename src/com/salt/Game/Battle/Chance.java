package com.salt.Game.Battle;

public class Chance {
    public static boolean oneInTen() {
        int chance = (int) (Math.random()*11);
        if (chance == 1 || chance == 2 || chance == 3 || chance == 4 || chance == 5 || chance == 6 || chance == 7 || chance == 8 || chance == 9) {
            return true;
        }
        return false;
    }

    public static boolean oneInTwenty() {
        int chance = (int) (Math.random()*21);
        if (chance == 1 || chance == 2 || chance == 3 || chance == 4 || chance == 5 || chance == 6 || chance == 7 || chance == 8 || chance == 9 || chance == 10 || chance == 11 || chance == 12 || chance == 13 || chance == 14 || chance == 15 || chance == 16 || chance == 17 || chance == 18 || chance == 19) {
            return true;
        }
        return false;
    }
}
