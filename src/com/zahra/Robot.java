package com.zahra;


public class Robot {
    private int x;
    private int y;
    private boolean initial;
    private String[] directions = new String[]{"NORTH", "EAST", "SOUTH", "WEST"};
    private int directionPointer = -1;

    public Robot() {
        this.initial = false;
    }

    public void place(int x, int y, String f) {
        if (x < 0 || x > 4 || y < 0 || y > 4) {
            throw new IllegalArgumentException("enter x and y between [0,4]");
        }
        for (int i = 0; i < directions.length; i++)
            if (this.directions[i].equals(f))
                this.directionPointer = i;
        if (this.directionPointer == -1)
            throw new IllegalArgumentException("enter valid direction.");
        this.x = x;
        this.y = y;
        this.initial = true;
    }

    public void move() {
        if (!this.initial)
            throw new IllegalArgumentException("you should enter PLACE, at the first");

        if (directions[directionPointer].equals("NORTH")) {
            if (this.y == 4)
                throw new IllegalStateException("robot can't move.y will be out of range [0,4]");
            this.y++;
        } else if (directions[directionPointer].equals("SOUTH")) {
            if (this.y == 0)
                throw new IllegalStateException("robot can't move.y will be out of range [0,4]");
            this.y--;
        } else if (directions[directionPointer].equals("EAST")) {
            if (this.x == 4)
                throw new IllegalStateException("robot can't move.x will be out of range [0,4]");
            this.x++;
        } else if (directions[directionPointer].equals("WEST")) {
            if (this.x == 0)
                throw new IllegalStateException("robot can't move.x will be out of range [0,4]");
            this.x--;
        }
    }

    public void right() {
        if (!this.initial)
            throw new IllegalArgumentException("you should enter PLACE, at the first");
        if (this.directionPointer == directions.length - 1)
            directionPointer = 0;
        else
            this.directionPointer++;
    }

    public void left() {
        if (!this.initial)
            throw new IllegalArgumentException("you should enter PLACE, at the first");
        if (this.directionPointer == 0)
            this.directionPointer = directions.length - 1;
        else
            this.directionPointer--;
    }

    public String report() {
        if (!this.initial)
            throw new IllegalArgumentException("you should enter PLACE, at the first");
        return x + "," + y + "," + directions[directionPointer];
    }

}