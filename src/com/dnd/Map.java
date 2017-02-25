package com.dnd;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by John on 2017-02-19.
 */
public class Map {
    public static List<String[]> possibleCoords = new ArrayList<>();
    public static void generateMap()
    {
        com.dnd.MapReader.loadCurrentMapComponent("testMap");
    }
}
