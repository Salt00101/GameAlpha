package com.salt.Game.Stats;

public class BoostStats {
    public int HP;
    public int MP;
    public int Atk;
    public int Def;
    public int Int;
    public int Wis;
    public int Spd;

    public BoostStats(int HP, int MP, int Atk, int Def, int Wis, int Spd) {
        this.HP = HP;
        this.MP = MP;
        this.Atk = Atk;
        this.Def = Def;
        this.Wis = Wis;
        this.Spd = Spd;
    }

    public int getAtk() { return Atk; }

    public int getDef() { return Def; }

    public int getInt() { return Int; }

    public int getWis() {
        return Wis;
    }

    public int getSpd() {
        return Spd;
    }

    public int getHP() { return HP; }

    public void changeHP(int factor) {
        if (HP - factor > 0) {
            HP -= factor;
        } if (HP - factor == 0) {
            HP = 0;
        }
    }
}
