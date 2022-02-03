package com.salt.Game.Player;

import com.salt.Game.Item.Item;
import com.salt.Game.Item.ItemList;
import com.salt.Game.Render.Entity;
import com.salt.Game.Stats.Stats;
import com.salt.Game.Vector.Vector2;
import com.salt.Game.Vector.Vector3;

import java.util.HashMap;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;

public class Player {
    public static Stats stats = new Stats(0, 1);
    private static HashMap<Integer, Item> inventory = new HashMap<>();
    public static int inventory_size = 12;
    private static HashMap<Integer, Item> gear = new HashMap<>();
    public static Entity player = new Entity(new Vector3(1.0f, 0.0f, 0.0f), new Vector2(-1.125f/16, 1f/9), new Vector2(1.125f/16, 1f/9), new Vector2(1.125f/16, -1f/9), new Vector2(-1.125f/16, -1f/9));

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

    public static void move(boolean w, boolean s, boolean a, boolean d) {
        if (w && a) {
            glClear(GL_COLOR_BUFFER_BIT);
            player.upLeft();
            player.draw();
        }

        if (w && d) {
            glClear(GL_COLOR_BUFFER_BIT);
            player.upRight();
            player.draw();
        }

        if (s && a) {
            glClear(GL_COLOR_BUFFER_BIT);
            player.downLeft();
            player.draw();
        }

        if (s && d) {
            glClear(GL_COLOR_BUFFER_BIT);
            player.downRight();
            player.draw();
        }

        if (w) {
            glClear(GL_COLOR_BUFFER_BIT);
            player.up();
            player.draw();
        }

        if (a) {
            glClear(GL_COLOR_BUFFER_BIT);
            player.left();
            player.draw();
        }

        if (s) {
            glClear(GL_COLOR_BUFFER_BIT);
            player.down();
            player.draw();
        }

        if (d) {
            glClear(GL_COLOR_BUFFER_BIT);
            player.right();
            player.draw();
        }
    }
}
