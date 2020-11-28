package com.zahra;

import java.util.Scanner;

public class InputReader {
    Robot robot;
    private Scanner scanner;

    public InputReader(Robot robot) {
        this.scanner = new Scanner(System.in);
        this.robot = robot;
    }

    public void enterInput() {
        System.out.println(gameGuide());
        while (true) {
            try {
                String nextLine = scanner.nextLine().toUpperCase();
                if (nextLine.equals("EXIT")) {
                    break;
                }
                if (nextLine.equals("REPORT")) {
                    String report = robot.report();
                    System.out.println(report);
                } else if (nextLine.equals("MOVE"))
                    robot.move();
                else if (nextLine.equals("LEFT"))
                    robot.left();
                else if (nextLine.equals("RIGHT"))
                    robot.right();
                else if (nextLine.startsWith("PLACE")) { //PLACE 0,0,NORTH
                    checkPlaceOrder(nextLine);
                } else
                    throw new IllegalArgumentException("incorrect input.");
            } catch (IllegalArgumentException | IllegalStateException | ArrayIndexOutOfBoundsException ex) {
                System.out.println(ex.getMessage() + "\ngo on!");
            }
        }
    }

    private void checkPlaceOrder(String nextLine) {
        String[] firstSplitWithSpace = nextLine.split(" ");
        if (!firstSplitWithSpace[0].equals("PLACE"))
            throw new IllegalArgumentException("enter correct order");
        if (firstSplitWithSpace.length == 1)
            throw new ArrayIndexOutOfBoundsException("initial position after PLACE order");
        String[] location = firstSplitWithSpace[1].split(",");
        if (location.length != 3)
            throw new IllegalArgumentException("enter correct position,for example:  place 2,3,west");
        int x, y;
        try {
            x = Integer.parseInt(String.valueOf(location[0]));
            y = Integer.parseInt(String.valueOf(location[1]));
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("x and y must be number ");
        }
        String direction = location[2];
        robot.place(x, y, direction);
    }

    private String gameGuide() {
        String gameGuide = "please select your operation as follows:\n" +
                "\"move\" for move Robot in assigned direction\n" +
                "\"left\" for turn Robot to left\n" +
                "\"right\" for turn Robot to right\n" +
                "\"report\" for see Robot position and direction\n" +
                "\"exit\" for quit Robot Game \n" +
                "\"place\" for put robot in one position,\n" +
                "write this command in this format: place x,y,direction, \n" +
                "then Robot placed in x,y,direction position,\n" +
                "x and y must be between 0 to 4 \n" +
                "and direction must be one of the north,south,east,west\n" +
                "NOTE that for start game you must select place operation at the first time.";
        return gameGuide;
    }

}
