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
        while (true) {
            try {
                String nextLine = scanner.nextLine();
                if (nextLine.equals("REPORT")) {
                    String report = robot.report();
                    System.out.println(report);
                    break;
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
                System.out.println(ex.getMessage() + "\nplay again!");
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
        robot.place(Integer.parseInt(String.valueOf(location[0])),
                Integer.parseInt(String.valueOf(location[1])),
                location[2]);
    }

}
