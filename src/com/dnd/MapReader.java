package com.dnd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by John on 2017-02-08.
 */
public class MapReader {
    private static String mapDir;
    private static int counter = 0;
    public static void loadMap(String filename)
    {
        mapDir = Main.dir + "\\map\\" + filename + "\\map_config.txt";
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
            counter = 0;
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
                        String test = o;
                        Main.loadedItems.add(count,test);
                        count++;
                    }
                    break;
                case 3:
                    break;
            }
            counter++;
        }


    }
    public static void bufferObjects(String fileName)
    {

    }
}
