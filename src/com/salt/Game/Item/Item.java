package com.salt.Game.Item;

import com.salt.Game.Stats.BoostStats;
import com.salt.Game.Stats.Stats;

public class Item {
    private String name;
    private String description;
    private int tag;
    public int type;
    private int tier;
    public BoostStats boost;

    public Item() {
        this.name = null;
        this.tag = -1;
        this.type = -1;
        this.tier = -1;
        this.boost = new BoostStats(0, 0, 0, 0, 0, 0);
    }

    public Item(String name, int tag, int type, int tier, BoostStats boost) {
        this.name = name;
        this.tag = tag;
        this.type = type;
        this.tier = tier;
        this.boost = boost;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return name + " - " + description;
    }


}
