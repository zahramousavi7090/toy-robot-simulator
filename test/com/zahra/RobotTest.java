package com.zahra;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class RobotTest {
    Robot robot;

    @Before
    public void needRunBeforeTest() {
        this.robot = new Robot();
    }

    @Test
    public void place_with_correct_input() {
        robot.place(0, 0, "NORTH");
        String result = robot.report();
        assertEquals(result, "0,0,NORTH");
    }

    @Test(expected = IllegalArgumentException.class)
    public void place_with_x_less_than_zero() {
        robot.place(-1, 0, "NORTH");
    }

    @Test(expected = IllegalArgumentException.class)
    public void place_with_x_more_than_four() {
        robot.place(5, 0, "NORTH");
    }

    @Test(expected = IllegalArgumentException.class)
    public void place_with_y_less_than_zero() {
        robot.place(0, -1, "NORTH");
    }

    @Test(expected = IllegalArgumentException.class)
    public void place_with_y_more_than_four() {
        robot.place(0, 5, "NORTH");
    }

    @Test(expected = IllegalArgumentException.class)
    public void place_with_invalid_direction() {
        robot.place(0, 0, "invalid");
    }

    @Test(expected = IllegalArgumentException.class)
    public void call_move_before_place_first_time() {
        robot.move();
    }

    @Test(expected = IllegalStateException.class)
    public void move_y_fewer_than_range() {
        robot.place(0, 0, "SOUTH");
        robot.move();
    }

    @Test(expected = IllegalStateException.class)
    public void move_y_more_than_range() {
        robot.place(0, 4, "NORTH");
        robot.move();
    }

    @Test(expected = IllegalStateException.class)
    public void move_x_fewer_than_range() {
        robot.place(0, 0, "WEST");
        robot.move();
    }

    @Test(expected = IllegalStateException.class)
    public void move_x_more_than_range() {
        robot.place(4, 0, "EAST");
        robot.move();
    }

    @Test
    public void move_y_correct_range_more_than_zero() {
        robot.place(0, 0, "NORTH");
        robot.move();
        String result = robot.report();
        assertEquals(result, "0,1,NORTH");
    }

    @Test
    public void move_y_correct_range_less_than_four() {
        robot.place(0, 4, "SOUTH");
        robot.move();
        String result = robot.report();
        assertEquals(result, "0,3,SOUTH");
    }

    @Test
    public void move_x_correct_range_more_than_zero() {
        robot.place(0, 0, "EAST");
        robot.move();
        String result = robot.report();
        assertEquals(result, "1,0,EAST");
    }

    @Test
    public void move_x_correct_range_less_than_four() {
        robot.place(4, 0, "WEST");
        robot.move();
        String result = robot.report();
        assertEquals(result, "3,0,WEST");
    }

    @Test
    public void right_rotate_north_to_east() {
        robot.place(0, 0, "NORTH");
        robot.right();
        String result = robot.report();
        assertEquals(result, "0,0,EAST");
    }

    @Test
    public void right_rotate_east_to_south() {
        robot.place(0, 0, "EAST");
        robot.right();
        String result = robot.report();
        assertEquals(result, "0,0,SOUTH");
    }

    @Test
    public void right_rotate_south_to_west() {
        robot.place(0, 0, "SOUTH");
        robot.right();
        String result = robot.report();
        assertEquals(result, "0,0,WEST");
    }

    @Test
    public void right_rotate_west_to_north() {
        robot.place(0, 0, "WEST");
        robot.right();
        String result = robot.report();
        assertEquals(result, "0,0,NORTH");
    }

    @Test(expected = IllegalArgumentException.class)
    public void call_right_before_place_first_time() {
        robot.right();
    }

    @Test
    public void left_rotate_north_to_west() {
        robot.place(0, 0, "NORTH");
        robot.left();
        String result = robot.report();
        assertEquals(result, "0,0,WEST");
    }

    @Test
    public void left_rotate_west_to_south() {
        robot.place(0, 0, "WEST");
        robot.left();
        String result = robot.report();
        assertEquals(result, "0,0,SOUTH");
    }

    @Test
    public void left_rotate_south_to_east() {
        robot.place(0, 0, "SOUTH");
        robot.left();
        String result = robot.report();
        assertEquals(result, "0,0,EAST");
    }

    @Test
    public void left_rotate_east_to_north() {
        robot.place(0, 0, "EAST");
        robot.left();
        String result = robot.report();
        assertEquals(result, "0,0,NORTH");
    }

    @Test(expected = IllegalArgumentException.class)
    public void call_left_before_place_first_time() {
        robot.left();
    }

    @Test
    public void correct_report() {
        robot.place(3, 2, "WEST");
        String result = robot.report();
        assertEquals(result, "3,2,WEST");
    }

    @Test(expected = IllegalArgumentException.class)
    public void call_report_before_place_first_time() {
        robot.report();
    }

    @Test
    public void hybrid_test() {
        robot.place(1, 2, "EAST");
        robot.move();
        robot.move();
        robot.left();
        robot.move();
        String result = robot.report();
        assertEquals(result, "3,3,NORTH");
    }

    @Test
    public void hybrid_test_with_more_place() {
        robot.place(0, 0, "EAST");
        robot.move();
        robot.move();
        robot.move();
        robot.right();
        robot.place(0, 4, "EAST");
        robot.move();
        robot.move();
        robot.move();
        robot.right();
        String result = robot.report();
        assertEquals(result, "3,4,SOUTH");

    }
}
