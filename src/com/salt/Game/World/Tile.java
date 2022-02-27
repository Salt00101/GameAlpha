package com.salt.Game.World;

import com.salt.Game.Render.Entity;
import com.salt.Game.Vector.Vector2;

public class Tile {
    boolean isTaken;
    boolean isIntractable;
    boolean isBackground;
    int interactType;
    int state;
    Entity IEntityTile;

    public Tile(boolean isTaken, boolean isIntractable, boolean isBackground, int interactType, int state, String fName, Vector2 v1, Vector2 v2, Vector2 v3, Vector2 v4) {
        this.isTaken = isTaken;
        this.isIntractable = isIntractable;
        this.isBackground = isBackground;
        this.interactType = interactType;
        this.state = state;
        IEntityTile = new Entity(fName, v1, v2, v3, v4);
    }

    public Tile() {
        this.isTaken = true;
        this.isIntractable = false;
        this.isBackground = false;
        this.interactType = -1;
        this.state = -1;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    public boolean isIntractable() {
        return isIntractable;
    }

    public void setIntractable(boolean intractable) {
        isIntractable = intractable;
    }

    public boolean isBackground() {
        return isBackground;
    }

    public void setBackground(boolean background) {
        isBackground = background;
    }

    public int getInteractType() {
        return interactType;
    }

    public void setInteractType(int interactType) {
        this.interactType = interactType;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Entity getIEntityTile() {
        return IEntityTile;
    }

    public void setIEntityTile(Entity IEntityTile) {
        this.IEntityTile = IEntityTile;
    }

    public void drawTile() {

    }
}
