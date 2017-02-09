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
    public static void loadMap(String filename)
    {
        mapDir = Main.dir + "\\map\\" + filename + "\\map_config.txt";
            List<String> records = new ArrayList<>();
            try
            {
                BufferedReader reader = new BufferedReader(new FileReader(mapDir));
                String line;
                while ((line = reader.readLine()) != null)
                {
                    records.add(line);
                }
                reader.close();
            }
            catch (Exception e)
            {
                System.err.format("Exception occurred trying to read '%s'.", filename);
                e.printStackTrace();
            }
        System.out.println(records.size());
    }
}
