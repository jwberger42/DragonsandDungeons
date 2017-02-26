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
    public static void generateAllCoords()
    {

    }
}
