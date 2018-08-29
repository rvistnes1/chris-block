package com.company;

import java.util.ArrayList;
import java.util.Objects;

public class Tray {
    public Tray(ArrayList<Block> tray) {
        this.tray = new ArrayList<Block>();
        for (Block b: tray) {
            Block temp = new Block(b.height, b.width, b.y, b.x, b.id);
            this.tray.add(temp);
        }
    }

    ArrayList<Block> tray;
    String rep;
    int hash;


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != getClass()) {
            return false;
        }
        Tray tray = (Tray) obj;

        return Objects.equals(hashCode(), tray.hashCode());
    }

    public int getHash() {
        String together = new String();
        for (int i = 0; i < tray.size(); i++) {
            Block now = tray.get(i);
            String height = Integer.toString(now.height);
            String width = Integer.toString(now.width);
            String x = Integer.toString(now.x);
            String y = Integer.toString(now.y);
            String id = Integer.toString(now.id);
            String combined = height + " " + width + " " + y + " " + x + " ";
            together = together.concat(combined);
        }
        hash = together.hashCode();
        return hash;
    }

    @Override
    public int hashCode() {
        return getHash();
    }

}