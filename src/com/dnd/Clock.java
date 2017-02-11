package com.dnd;

import java.util.Scanner;
//Needs to be set in window format once I figure out how.
public class Clock
{ 
private static int worldClock = 0;

public static Scanner userin = new Scanner(System.in);

public Clock()
{
}

public static void loop()
{
doStuff();
}

public static void main(String[] args)
{
    loop();
}

public static void doStuff()
{
String test = userin.next();
if (test.contains("wait"))
{
worldClock = worldClock + 600;
System.out.println(worldClock);
}

if (worldClock == 2400)
{
worldClock = worldClock - 2400;
}
loop();
}
}
