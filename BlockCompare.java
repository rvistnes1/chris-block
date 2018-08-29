package com.company;

import java.util.Comparator;

public class BlockCompare implements Comparator<Block> {
    @Override
//    public int compare(Block a, Block b) {
//    }

    public int compare(Block a, Block b) {

        if (a.id > b.id) {
            return 1;
        }
        else if (a.id < b.id) {
            return -1;
        }
        else {
            return 0;
        }
            //
//         int distA = ((a.x*a.x - goalX*goalX) + (a.y*a.y - goalY*goalY));
//        int distB = ((b.x*b.x - goalX*goalX) + (b.y*b.y - goalY*goalY));
//        if (distA > distB) {
//            return 1;
//        }
//        else if (distA < distB) {
//            return -1;
//        }
//        else {
//            return 0;
//        }
        }

    }