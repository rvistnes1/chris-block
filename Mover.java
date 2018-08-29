package com.company;

import java.lang.reflect.Array;
import java.util.*;


public class Mover {
    public Mover(Queue<Tray> q, Tray curr, HashSet<Tray> prev, int Y, int X, int goalX, int goalY) {
        this.current = curr;
        this.previous = prev;
        this.queue = q;
        this.y = Y;
        this.x = X;
    }

    public Tray current;
    public HashSet<Tray> previous;
    public Queue<Tray> queue;
    public int y;
    public int x;
    public int goalX;
    public int goalY;

    public void solve() {
//        Collections.sort(current.tray, new BlockCompare());
        for (int i = 0; i < current.tray.size(); i++) {
            for (int n = 0; n < current.tray.size(); n++) {
                if (n == i) {
                    break;
                } else {
                    Block now = current.tray.get(i);
                    Block test = current.tray.get(n);
                    Tray saved = new Tray(current.tray);
                    Block help = saved.tray.get(i);
                    if (!leftOpen(now, test)) {
                        saved.tray.set(i, new Block(help.height, help.width, help.y, help.x - 1, help.id));
                        if (!previous.contains(saved)) {
                            queue.add(new Tray(saved.tray));
                            previous.add(new Tray(saved.tray));
                            System.out.println(saved.tray.get(i).height + " " + saved.tray.get(i).width + " " + saved.tray.get(i).y + " " + saved.tray.get(i).x + " left");
                        }
                        saved.tray.set(i, new Block(help.height, help.width, help.y + 1, help.x , help.id));
                    }
                    if (!rightOpen(now, test)) {
                        saved.tray.set(i, new Block(help.height, help.width, help.y, help.x + 1, help.id));
                        if (!previous.contains(saved)) {
                            queue.add(new Tray(saved.tray));
                            previous.add(new Tray(saved.tray));
                            System.out.println(saved.tray.get(i).height + " " + saved.tray.get(i).width + " " + saved.tray.get(i).y + " " + saved.tray.get(i).x + " right");
                        }
                        saved.tray.set(i, new Block(help.height, help.width, help.y, help.x - 1, help.id));
                    }
                    if (!upOpen(now, test)) {
                        saved.tray.set(i, new Block(help.height, help.width, help.y - 1, help.x, help.id));
                        if (!previous.contains(saved)) {
                            queue.add(new Tray(saved.tray));
                            previous.add(new Tray(saved.tray));
                            System.out.println(saved.tray.get(i).height + " " + saved.tray.get(i).width + " " + saved.tray.get(i).y + " " + saved.tray.get(i).x + " up");
                        }
                        saved.tray.set(i, new Block(help.height, help.width, help.y + 1, help.x , help.id));
                    }
                    if (!downOpen(now, test)) {
                        saved.tray.set(i, new Block(help.height, help.width, help.y + 1, help.x , help.id));
                        if (!previous.contains(saved)) {
                            queue.add(new Tray(saved.tray));
                            previous.add(new Tray(saved.tray));
                            System.out.println(saved.tray.get(i).height + " " + saved.tray.get(i).width + " " + saved.tray.get(i).y + " " + saved.tray.get(i).x + " down");                        }
                    }
                    saved.tray.set(i, new Block(help.height, help.width, help.y - 1, help.x , help.id));
                }
            }
        }
    }


    public boolean leftOpen(Block now, Block test) {
        boolean blocked = false;
        if (now.x == 0) {
            blocked = true;
        }
        //it will only block if test is to the left of now
        if (now.x > test.x) {
            //test if the right edge of test is in the column directly left of the now block
            if ((now.x) == (test.x + test.width)) {
                //test row is at most the ending row of now
                if (test.y <= (now.y + now.height - 1)) {
                    //test ending row is at least the beginning row of now
                    if ((test.y + test.height - 1) >= now.y) {
                        blocked = true;
                    }
                }
            }
        }
        return blocked;
    }

    public boolean rightOpen(Block now, Block test) {
        boolean blocked = false;
        if ((now.x + now.width) >= x) {
            blocked = true;
        }
        if ((now.x + now.width - 1) < test.x) {
            if ((now.x + now.width) == (test.x)) {
                if (test.y <= (now.y + now.height - 1)) {
                    if ((test.y + test.height - 1) >= now.y) {
                        blocked = true;
                    }
                }
            }
        }
        return blocked;
    }

    public boolean upOpen(Block now, Block test) {
        boolean blocked = false;
        if (now.y <= 0) {
            blocked = true;
        }
        if (now.y == (test.y + test.height)) {
            if ((now.x + now.width - 1) >= test.x) {
                if ((test.x + test.width - 1) >= now.x) {
                    blocked = true;
                }
            }
        }
        return blocked;
    }

    public boolean downOpen(Block now, Block test) {
        boolean blocked = false;
        if ((now.y + now.height) >= y) {
            blocked = true;
        }
        if ((now.y + now.height - 1) < test.y) {
            if ((now.y + now.height) == (test.y)) {
                if ((now.x + now.width - 1) >= test.x) {
                    if ((test.x + test.width) >= now.x) {
                        blocked = true;
                    }
                }
            }
        }
        return blocked;
    }
}
