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
    public void test1(){
        robot.place(0,0,"NORTH");
        String result=robot.report();
        assertEquals(result,"0,0,NORTH");
    }

    @Test
    public void test2(){
        robot.place(0,0,"NORTH");
        robot.move();
        String result=robot.report();
        assertEquals(result,"0,1,NORTH");
    }

    @Test
    public void test3(){
        robot.place(0,0,"NORTH");
        robot.left();
        String result=robot.report();
        assertEquals(result,"0,0,WEST");
    }

    @Test
    public void test4(){
        robot.place(0,0,"NORTH");
        robot.right();
        String result=robot.report();
        assertEquals(result,"0,0,EAST");
    }

    @Test
    public void test5(){
        robot.place(1,2,"EAST");
        robot.move();
        robot.move();
        robot.left();
        robot.move();
        String result=robot.report();
        assertEquals(result,"3,3,NORTH");
    }
}
