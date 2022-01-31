package com.salt.Game.Player;

import com.salt.Game.Item.Item;
import com.salt.Game.Item.ItemList;
import com.salt.Game.Stats.Stats;

import java.util.HashMap;

public class Player {
    public static Stats stats = new Stats(0, 1);
    private static HashMap<Integer, Item> inventory = new HashMap<>();
    public static int inventory_size = 12;
    private static HashMap<Integer, Item> gear = new HashMap<>();

    public static void addItem(int index, Item item) {
        if (index >= 0 && index <= inventory_size) {
            inventory.put(index, item);
            stats.boost(item);
        } else {
            throw new ArrayIndexOutOfBoundsException("Error in class Player.java, method addItem: Player.index > Player.inventory_size");
        }
    }

    public static Item getItem(int index) {
        if (index >= 0 && index <= inventory_size) {
            return inventory.get(index);
        }
        return ItemList.NULL;
    }

    public static void removeItem(int index) {
        if (index >= 0 && index <= inventory_size) {
             inventory.remove(index);
        } else {
            throw new ArrayIndexOutOfBoundsException("Error in class Player.java, method removeItem: Player.index > Player.inventory_size");
        }
    }

    public static void invToGear(int index) {
        if (inventory.get(index).type == 1) {
            
        }
    }

    public static void printAllItemType(int type) {
        for (Item s : inventory.values()) {
            System.out.println(s.toString());
        }
    }
}
