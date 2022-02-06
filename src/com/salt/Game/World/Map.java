package com.salt.Game.World;

public class Map {
    Chunk[][] map;
    int px;
    int py;

    public Map(Chunk[][] map) {
        this.map = map;
    }

    public int getPx() {
        return px;
    }

    public int getPy() {
        return py;
    }
}
