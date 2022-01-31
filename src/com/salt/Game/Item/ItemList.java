package com.salt.Game.Item;

import com.salt.Game.Stats.BoostStats;

public class ItemList {
    /*
    Name: Item name; Can have whitespaces
    Tag: item tag from 1 - [max number of items]
    Type: 0 - special; 1 - weapons; 2 - armors; 3 - consumables; 4 - resources
    Tier: 0 - low; 1 - medium:low; 2 - medium; 3 - medium:high; 4 - high; 5 - expert; 6 - special
     */
    public static final Item NULL = new Item();
    public static final Item WOOD_SWORD = new Item("Wooden Sword", 1, 1, 0, new BoostStats(0,0, 2, 0, 0, 0));
}
