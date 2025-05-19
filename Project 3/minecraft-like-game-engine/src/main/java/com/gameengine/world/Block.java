package com.gameengine.world;

import java.awt.Image;
import java.awt.Point;

public class Block {
    private String type;
    private int x, y, z;
    private Image texture;

    public Block(String type, int x, int z) {
        this.type = type;
        this.x = x;
        this.z = z;
        this.y = 0; // Default y
        this.texture = null; // Set texture as needed
    }

    public String getType() { return type; }
    public int getX() { return x; }
    public int getY() { return y; }
    public int getZ() { return z; }
    public Image getTexture() { return texture; }
    public Point getPosition() { return new Point(x, z); }
}