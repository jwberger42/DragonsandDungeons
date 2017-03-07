package com.dnd;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.dnd.Map.startCoords;

/**
 * Created by John on 2017-02-08. Hi!
 */
class MapReader {
    static void loadMap(String filename) throws IOException {
        String mapDir = Main.dir + "\\map\\" + filename + "\\map_config.txt";
            List<String> mapLength = new ArrayList<>();
            try
            {
                BufferedReader reader = new BufferedReader(new FileReader(mapDir));
                String line;
                while ((line = reader.readLine()) != null)
                {
                    mapLength.add(line);
                }
                reader.close();
            }
            catch (Exception e)
            {
                System.err.format("Exception occurred trying to read '%s'.", filename);
                e.printStackTrace();
            }
        int counter = 0;
        for (String i : mapLength)
        {
            switch(counter)
            {
                case 0:
                    Main.difficultyModifier = Integer.parseInt(i);
                    break;
                case 1:
                    String[] a = i.split(";");
                    Main.mapBoundsX = Integer.parseInt(a[0]);
                    Main.mapBoundsY = Integer.parseInt(a[1]);
                    break;
                case 2:
                    int count = 0;
                    String[] s = i.split(";");
                    for (String o : s)
                    {
                        System.out.println(o);
                        Main.loadedItems.add(count, o);
                        count++;
                    }
                    break;
                case 3:
                    break;
                case 4:
                    loadAllCoords(1,filename);
                    break;
            }
            counter++;
        }
    }
    public static void loadCurrentMapComponent(String filename)
    {
        String mapDir = Main.dir + "\\map\\" + filename + "\\mapAreas";
        File mapCompList = new File(mapDir);
        File[] mapList = mapCompList.listFiles();
        for (File i : mapList)
        {
            System.out.println(i.toString());
        }
    }
    public static void loadAllCoords(int curFileNum, String fileName) throws IOException {
        BufferedReader fileSizer = new BufferedReader(new FileReader(Main.dir + "\\map\\" + fileName + "\\mapAreas\\" + "a" + curFileNum + ".txt"));
        String linNum;
        for (int i = 0;i < 2;i++) {
            switch(i)
            {
                case 0:
                    Map.areaName = fileSizer.readLine();

                    break;
                case 1:
                    for(String o : fileSizer.readLine().split(":"))
                    {
                        startCoords.add(o);
                    }
                    Map.generateAllCoords();
                    break;
            }
        }
    }
}
