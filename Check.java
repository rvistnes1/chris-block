package com.company;

import java.util.*;

public class Check {
    public Check(ArrayList<Block> solution) { ;
        this.solution = solution;
    }
    ArrayList<Block> solution;

    public boolean checker (Tray current) {
        int counter = 0;
        for (int i = 0; i < current.tray.size(); i++) {
            Block curr = current.tray.get(i);
            for (int n = 0; n < solution.size(); n++) {
                Block now = solution.get(n);
                if (curr.x == now.x &&
                        curr.y == now.y &&
                        curr.width == now.width &&
                        curr.height == now.height) {
                    counter ++;
                }
            }
        }
        return counter == solution.size();
    }
}
