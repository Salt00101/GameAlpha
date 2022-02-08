package com.salt.Game.World;

public class Chunk {
    public Tile[][] chunk;
    public int dx = 0;
    public int dy = 0;
    public boolean isBorder;

    public Chunk(Tile[][] chunk) {
        this.chunk = chunk;
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
