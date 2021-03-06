package com.dnd;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jwberger42 on 2017-02-19.
 */
public class Map {
    public static String areaName;
    public static List<String[]> possibleCoords = new ArrayList<>();
    public static List<String> startCoords = new ArrayList<>();
    public static void generateMap()
    {
        com.dnd.MapReader.loadCurrentMapComponent("testMap");
    }
    public static List<String> allX = new ArrayList<>();
    public static List<String> allY = new ArrayList<>();
    private static int counter = 0;
    public static  String[][] fullCoordMap;
    public static void generateAllCoords()
    {
        System.out.println("You are in: " + areaName);
        for(String i : startCoords) {
            System.out.println(i);
            String[] coooords = startCoords.get(counter).split(";");
            String[] isolatedCoords = coooords[0].split(",");
            String[] isolatedCoords2 = coooords[1].split(",");
            int x1 = Integer.parseInt(isolatedCoords[0]);
            System.out.println(x1);
            int y1 = Integer.parseInt(isolatedCoords[1]);
            System.out.println(y1);
            int x2 = Integer.parseInt(isolatedCoords2[0]);
            System.out.println(x2);
            int y2 = Integer.parseInt(isolatedCoords2[1]);
            System.out.println(y2);
            counter++;
            fullCoordMap = new String[x2-x1][y2-y1];
            for (int w = 0; w < fullCoordMap.length; w++) {
                for (int j = 0; j < fullCoordMap[w].length; j++) {
                    fullCoordMap[w][j] = String.valueOf(w) + "," + String.valueOf(j);
                }
            }
            for (String[] a : fullCoordMap) {
                for (String u : a) {
                    System.out.print(u + "\t");
                }
                System.out.println("\n");
            }

        }

    }
}
