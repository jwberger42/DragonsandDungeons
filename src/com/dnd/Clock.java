package com.dnd;

//test in eclipse ver 1.0 note code is unfinished
import java.util.scanner;

public class Clock
{
//this is the defined value for the twenty four hour clock
private static int worldClock = 0;
//Scanner code
public static Scanner userin = new Scanner(System.in);
/**
*Constructor for class Clock
*/

public Clock()
{
}

public static void loop();
{
doStuff;
}

public static void main(String[] args)
{
loop();
}

public static void doStuff()
{
String test = userin.next();
//Code to detect values.
if (test.contains("wait"))
{
worldClock = worldClock + 100;
System.out.println(worldClock);
}
}

