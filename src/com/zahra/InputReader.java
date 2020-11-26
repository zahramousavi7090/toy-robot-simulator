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
            String nextLine = scanner.nextLine();
            if (nextLine.equals("REPORT")) {
                String report = robot.report();
                System.out.println(report);
                break;
            }
            if (nextLine.equals("MOVE"))
                robot.move();
            if (nextLine.equals("LEFT"))
                robot.left();
            if (nextLine.equals("RIGHT"))
                robot.right();
            if (nextLine.startsWith("PLACE")) { //PLACE 0,0,NORTH
                String[] location = nextLine.split(" ")[1].split(",");
                robot.place(Integer.parseInt(String.valueOf(location[0])),
                        Integer.parseInt(String.valueOf(location[1])),
                        location[2]);
            }
        }
    }

}
