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
                    String[] location = nextLine.split(" ")[1].split(",");
                    robot.place(Integer.parseInt(String.valueOf(location[0])),
                            Integer.parseInt(String.valueOf(location[1])),
                            location[2]);
                } else
                    throw new IllegalArgumentException("incorrect input.");
            } catch (IllegalArgumentException | IllegalStateException ex) {
                System.out.println(ex.getMessage() + "\nplay again!");
            }
        }
    }

}
