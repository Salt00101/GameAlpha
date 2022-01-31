package com.salt.Game.Stats;

import com.salt.Game.Item.Item;

public class Stats {
    public int MAX_HP;
    public int MAX_MP;
    public int HP;
    public int MP;
    public int Atk;
    public int Def;
    public int Int;
    public int Wis;
    public int Spd;
    public int xp;
    public int lvl;
    public int threshold;
    public boolean isDead;

    public Stats(int base, int lvl) {
        xp = 0;
        this.lvl = lvl;
        changeStats(base);
        changeThreshold();
        isDead = false;
    }

    public void addXp(int xp, int base) {
        this.xp += xp;
        while (this.xp + xp >= threshold) {
            this.xp -= threshold;
            addLvl(base);
        }
    }

    public void addLvl(int base) {
        lvl++;
        changeThreshold();
        changeStats(base);
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

    public void changeStats(int base) {
        HP = (int) Math.floor(Math.sqrt(200*lvl));
        MP = (int) Math.floor(Math.sqrt(200*lvl));
        MAX_HP = (int) Math.floor(Math.sqrt(200*lvl));
        MAX_MP = (int) Math.floor(Math.sqrt(200*lvl));
        Atk = (int) Math.sqrt(190*lvl - 3) - base;
        Def = (int) Math.sqrt(190*lvl - 1) - base;
        Int = (int) Math.sqrt(180*lvl  + 3) - base;
        Wis = (int) Math.sqrt(181*lvl + 1) - base;
        Spd = (int) Math.sqrt(158*lvl + 1) - base;
    }

    public void boost(Item i) {
        this.HP += i.boost.HP;
        this.MP += i.boost.MP;
        this.Atk += i.boost.Atk;
        this.Def += i.boost.Def;
        this.Int += i.boost.Int;
        this.Wis += i.boost.Wis;
        this.Spd += i.boost.Spd;
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

    public float getHpPercent() {
        return (float) (HP/MAX_HP * 100);
    }
}
