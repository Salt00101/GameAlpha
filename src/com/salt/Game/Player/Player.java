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
    static Vector3 color = new Vector3(1.0f,0.0f,0.0f);
    public static Vector2 v1 = new Vector2(0.0f/16,-1f/9);
    public static Vector2 v2 = new Vector2(0.0f/16,1f/9);
    public static Vector2 v3 = new Vector2(2.0f/16,1f/9);
    public static Vector2 v4 = new Vector2(2.0f/16,-1f/9);
    public static Entity player = new Entity(color, v1, v2, v3, v4);
    public static int dx = 0;
    public static int dy = 0;
    public static int px = 0;
    public static int py = 0;

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

    public static void up() {
        glClear(GL_COLOR_BUFFER_BIT);
        Movement.w();
        Player.player.draw();
    }

    public static void down() {
        glClear(GL_COLOR_BUFFER_BIT);
        Movement.s();
        Player.player.draw();
    }

    public static void left() {
        glClear(GL_COLOR_BUFFER_BIT);
        Movement.a();
        Player.player.draw();
    }

    public static void right() {
        glClear(GL_COLOR_BUFFER_BIT);
        Movement.d();
        Player.player.draw();
    }
}
