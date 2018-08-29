package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Queue<Tray> queue = new ArrayDeque<>();
        HashSet<Tray> previous = new HashSet<>();
        ArrayList<Block> blocksArray = new ArrayList<Block>();
        ArrayList<Block> solution = new ArrayList<Block>();
        int trayHeight;
        int trayWidth;
        try (BufferedReader br = new BufferedReader(new FileReader("file"))) {
            String line;
            String firstLine = br.readLine();
            trayHeight = Integer.parseInt(firstLine.substring(0, firstLine.indexOf(' ')));
            firstLine = firstLine.substring(firstLine.indexOf(' ') + 1);
            trayWidth = Integer.parseInt(firstLine);
            int blockid = 1;
            while ((line = br.readLine()) != null) {
                int blockHeight = Integer.parseInt(line.substring(0, line.indexOf(' ')));
                line = line.substring(line.indexOf(' ') + 1);
                int blockWidth = Integer.parseInt(line.substring(0, line.indexOf(' ')));
                line = line.substring(line.indexOf(' ') + 1);
                int Y = Integer.parseInt(line.substring(0, line.indexOf(' ')));
                line = line.substring(line.indexOf(' ') + 1);
                int X = Integer.parseInt(line);
                blocksArray.add(new Block(blockHeight, blockWidth, Y, X, blockid));
                ++blockid;
            }
        }
        try (BufferedReader br = new BufferedReader(new FileReader("solution"))) {
            String line;
            while ((line = br.readLine()) != null) {
                int goalHeight = Integer.parseInt(line.substring(0, line.indexOf(' ')));
                line = line.substring(line.indexOf(' ') + 1);
                int goalWidth = Integer.parseInt(line.substring(0, line.indexOf(' ')));
                line = line.substring(line.indexOf(' ') + 1);
                int goalY = Integer.parseInt(line.substring(0, line.indexOf(' ')));
                line = line.substring(line.indexOf(' ') + 1);
                int goalX = Integer.parseInt(line);
                solution.add(new Block(goalHeight, goalWidth, goalY, goalX, 0));
            }
            Tray start = new Tray(blocksArray);
            Check goal = new Check(solution);
            queue.add(start);
//            Block block1 = new Block(1, 2, 3,4, 5);
//            Block block2 = new Block(1, 2, 3,4, 5);
//            Block block3 = new Block(2, 3, 4,5, 6);
//            ArrayList<Block> test1 = new ArrayList<>();
//            ArrayList<Block> test2 = new ArrayList<>();
//            ArrayList<Block> test3 = new ArrayList<>();
//            test1.add(block1);
//            Tray tray1 = new Tray(test1);
//            test2.add(block2);
//            test2.add(block3);
//            Tray tray2 = new Tray(test2);
//            test3.add(block1);
//            test3.add(block3);
//            Tray tray3 = new Tray(test3);
//            previous.add(tray2);
//
//            System.out.println(previous.contains(tray3));
//            System.out.println(tray2.hashCode());
//            System.out.println(tray3.hashCode());
            boolean solved = false;
            while (!queue.isEmpty()) {
                Tray current = queue.poll();
//                previous.add(current);
                if (goal.checker(current)) {
                    solved = true;
                    break;
                } else {
                    Mover mover = new Mover(queue, current, previous, trayHeight, trayWidth, solution.get(0).x, solution.get(0).y);
                    mover.solve();
                }
            }
            if (solved) {
                System.out.println("YES!");
            } else {
                System.out.println("nope");
            }
        }
    }
}

