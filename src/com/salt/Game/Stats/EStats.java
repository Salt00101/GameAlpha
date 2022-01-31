package com.salt.Game.Stats;

public class EStats {
    public int MAX_HP;
    public int MAX_MP;
    public int HP;
    public int MP;
    public int Atk;
    public int Def;
    public int Int;
    public int Wis;
    public int Spd;
    public int base;
    public int xp;
    public int lvl;
    public int threshold;
    public boolean isDead;

    public EStats(int base, int lvl) {
        xp = 0;
        this.base = base;
        this.lvl = lvl;
        changeStats();
        changeThreshold();
        isDead = false;
    }

    public void addXp(int xp, int base) {
        this.xp += xp;
        while (this.xp + xp >= threshold) {
            this.xp -= threshold;
            addLvl();
        }
    }

    public void addLvl() {
        lvl++;
        changeThreshold();
        changeStats();
    }

    public void changeThreshold() {
        if (lvl < 50) {
            threshold = (((int) Math.pow((lvl + 1), 3)) * (100 - (lvl + 1)))/50;
        } else if (lvl >= 50 && lvl < 68) {
            threshold = (((int) Math.pow((lvl + 1), 3)) * (150 - (lvl + 1)))/100;
        } else if (lvl >= 68 && lvl < 98) {
            threshold = (((int) Math.pow((lvl + 1), 3)) * ((int) Math.floor((1911.0 - (10.0*(lvl + 1)))/3)))/500;
        } else if (lvl >= 98) {
            threshold = (((int) Math.pow((lvl + 1), 3)) * (160 - (lvl + 1)))/100;
        }
    }

    public void changeStats() {
        HP = (int) Math.floor(Math.sqrt(201*lvl));
        MP = (int) Math.floor(Math.sqrt(199*lvl));
        MAX_HP = (int) Math.floor(Math.sqrt(201*lvl));
        MAX_MP = (int) Math.floor(Math.sqrt(199*lvl));
        Atk = (int) Math.round(Math.sqrt(195*lvl - base - 2));
        Def = (int) Math.round(Math.sqrt(121*lvl - base - 2));
        Int = (int) Math.round(Math.sqrt(170*lvl - base - 1));
        Wis = (int) Math.round(Math.sqrt(171*lvl - base - 1));
        Spd = (int) Math.round(Math.sqrt(137*lvl - base + 1));
    }

    public int getAtk() {
        return Atk;
    }

    public int getDef() {
        return Def;
    }

    public int getInt() {
        return Int;
    }

    public int getWis() {
        return Wis;
    }

    public int getSpd() {
        return Spd;
    }

    public void changeHP(int factor) {
        if (HP - factor > 0) {
            HP -= factor;
        } if (HP - factor == 0) {
            HP = 0;
            isDead = true;
        }
    }
}
