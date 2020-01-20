package dev.hyperlisk.nintanks.util;

import dev.hyperlisk.nintanks.entities.Wall;

import java.io.*;
import java.util.ArrayList;

public class MapHandler {

    private File mapfile;
    private BufferedReader reader;
    private ArrayList<Wall> walls = new ArrayList<>();

    private String line;
    private static MapHandler s_instance;


    public static MapHandler getInstance() {
        if(s_instance == null){
            s_instance = new MapHandler();
        }
        return s_instance;
    }

    private MapHandler() {
        mapfile = new File("map.txt");
        try {
            reader = new BufferedReader(new FileReader(mapfile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int x = 0; x < 32; x++) {
            try {
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int y = 0; y < 32; y++) {

                if(line == null) {
                    break;
                }

                if(line.charAt(y) == 'w') {
                    walls.add(new Wall(x, y, false));
                }

                if(line.charAt(y) == 'b') {
                    walls.add(new Wall(x, y, true));
                }



            }
            if(line == null) {
                break;
        }
    }
    }

    public ArrayList<Wall> getWalls() {

        return walls;

    }
}
