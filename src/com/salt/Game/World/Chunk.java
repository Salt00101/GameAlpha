package com.salt.Game.World;

import com.salt.Game.Vector.Vector2;

public class Chunk {
    public Tile[][] chunk = new Tile[16][9];
    public int dx = 0;
    public int dy = 0;
    public boolean isBorder;

    public Chunk(boolean isTaken, boolean isIntractable, boolean isBackground, int interactType, int state) {
        for (int i = 0; i < 16; i++) {
            Vector2 v1 = new Vector2((2.0f*i)/16, 0.0f/9);
            Vector2 v2 = new Vector2((2.0f*i)/16, 2.0f/9);
            Vector2 v3 = new Vector2((2.0f*i+2.0f)/16, 2.0f/9);
            Vector2 v4 = new Vector2((2.0f*i+2.0f)/16, 0.0f/9);
            for (int j = 0; j < 9; j++) {
                this.chunk[i][j] = new Tile(isTaken, isIntractable, isBackground, interactType, state, "/Users/anuppilla/Downloads/Game/resources/com/salt/Game/Texture/Single/grass.png", v1, v2, v3, v4);
                v1.y += 2.0f/9;
                v2.y += 2.0f/9;
                v3.y += 2.0f/9;
                v4.y += 2.0f/9;
            }

        }
    }

    public Chunk(boolean isBorder) {
        this.isBorder = isBorder;
        chunk = new Tile[][]{{new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile()}, {new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile()}, {new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile()}, {new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile()}, {new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile()}, {new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile()}, {new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile()}, {new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile()}};
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public boolean isBorder() {
        return isBorder;
    }

    public void setBorder(boolean border) {
        isBorder = border;
    }
}
