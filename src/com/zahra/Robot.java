package com.zahra;


public class Robot {
    private int x;
    private int y;
    private boolean initial;
    private String[] directions = new String[]{"NORTH", "EAST", "SOUTH", "WEST"};
    private int directionPointer;

    public void place(int x, int y, String f) {
        this.x = x;
        this.y = y;
        for (int i = 0; i < directions.length; i++)
            if (this.directions[i].equals(f))
                this.directionPointer = i;
        initial = true;
    }

    public void move() {
        if (directions[directionPointer].equals("NORTH"))
            this.y++;
        if (directions[directionPointer].equals("SOUTH"))
            this.y--;
        if (directions[directionPointer].equals("EAST"))
            this.x++;
        if (directions[directionPointer].equals("WEST"))
            this.x--;
    }

    public void right() {
        if (this.directionPointer == directions.length - 1)
            directionPointer = 0;
        else
            this.directionPointer++;
    }

    public void left() {
        if (this.directionPointer == 0)
            this.directionPointer = directions.length - 1;
        else
            this.directionPointer--;
    }

    public String report() {
        return x + "," + y + "," + directions[directionPointer];
    }

}