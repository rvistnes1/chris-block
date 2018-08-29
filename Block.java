package com.company;

import java.util.ArrayList;

public class Block {
    public Block(int blockHeight, int blockWidth, int Y, int X, int ID) {
        height = blockHeight;
        width = blockWidth;
        x = X;
        y = Y;
        id = ID;
    }

    public int height;
    public int width;
    public int x;
    public int y;
    public int id;

//    public boolean equals(Block other) {
//        System.out.println("penis");
//        Block that = other;
//        if (this.height == that.height && this.width == that.width && this.y == that.y && this.x == that.x && this.id == that.id) {
//            return true;
//            }
//        return false;
//    }
}
