package com.dnd;

import java.util.Scanner;
//need to get four directional movement done, item detection, and making sure player can't walk out of the world.
//test for forward movement was successful so on the right track.
//try to program array whatever the hell that means, learn about it pretty soon.
public class Location
{
  //world y values
  private static int northWorldedge = 5;
  private static int southWorldedge = -5;
  //world x values
  private static int eastWorldedge = 5;
  private static int westWorldedge = -5;
  //player world location
  private static int playerX = 0;
  private static int playerY = 0;
  //grappling hook location
  private static int hookX = 3;
  private static int hookY = 3;
  //Scanner code
  public static Scanner userin = new Scanner(System.in);
  
  public Location()
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
    if (test.contains("forward"))
    {
      playerY = playerY + 1;
      System.out.println(playerY);
    }
    loop();
  }
}

  
