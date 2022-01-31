package com.salt.Game.Enemy;

import com.salt.Game.Player.Player;
import com.salt.Game.Stats.EStats;

public class Enemy {
    public String race;
    public EStats stat;
    public int xpDrop;

    public Enemy(String race, int base, int lvl) {
        this.race = race;
        this.stat = new EStats(base, lvl);
        xpDrop = (int) (((62.0*stat.lvl)/5.0)*(Math.pow(((2*stat.lvl+10)/(10.0+stat.lvl+Player.stats.lvl)), 2.5)));
    }
}
