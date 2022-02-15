package com.salt.Game.World;

public class Chunk {
    public Tile[][] chunk = new Tile[16][9];
    public int dx = 0;
    public int dy = 0;
    public boolean isBorder;

    public Chunk(boolean isTaken, boolean isIntractable, boolean isBackground, int interactType, int state) {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 9; j++) {
                this.chunk[i][j] = new Tile(isTaken, isIntractable, isBackground, interactType, state);
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
