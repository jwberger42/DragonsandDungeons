package com.dnd;

import java.util.Scanner;
//need to get four directional movement done, item detection, and making sure player can't walk out of the world.
//test for forward movement was successful so on the right track.
//try to program array whatever the hell that means, learn about it pretty soon.
public class Items
{
    //world y values
    private static int upEdge = 5;
    private static int downEdge = -5;
    //world x values
    private static int rightEdge = 5;
    private static int leftEdge = -5;
    //player world location
    protected static int[] playerXY;
    //grappling hook location
    //Scanner code
    public static Scanner userin = new Scanner(System.in);

    public Items()
    {
    }

    public static void main(String[] args)
    {
        //Indian IT Guy, if you name methods loop or do stuff again I will end your face. Seriously. Using a method only to start the same one that called
        //it over and over again is not a good way to make a loop. USE A do while, or a for each, or a for, or a while. NOT THAT!!!
    }

    public static void doStuff()
    {
        String test = userin.next();
        if (test.contains("forward"))
        {
           playerXY[1]++;
        }
    }
}


