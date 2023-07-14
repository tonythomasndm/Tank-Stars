package com.badlogic.tankgame;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class Serializer{
    public static GameScreen current;
        static ArrayList<GameScreen> gamelist= new ArrayList<>();
    public static void serialize(GameScreen game)throws IOException {
        current=game;
        gamelist.add(current);
    }
    public static GameScreen deserialize()throws IOException, ClassNotFoundException{
        return gamelist.get(0);
    }
}
