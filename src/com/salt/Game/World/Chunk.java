package com.salt.Game.World;

public class Chunk {
    Tile[][] chunk;
    int dx;
    int dy;
    boolean isBorder;

    public Chunk(Tile[][] chunk) {
        this.chunk = chunk;
    }

    public Chunk(boolean isBorder) {
        this.isBorder = isBorder;
        dx = 0;
        dy = 0;
        chunk = new Tile[][]{{new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile()}, {new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile()}, {new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile()}, {new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile()}, {new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile()}, {new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile()}, {new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile()}, {new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile()}};
    }
}
