package folder1.Model;

import java.util.Random;
import java.util.Scanner;
import java.awt.*;
import java.io.*;
import folder1.Model.Hero;

public class Map {
    private int x;
    private int y;
    private Monster monster;


    public Map(int heroLv, boolean setMapSize) {
        int villain;
        if (setMapSize) {
            Globals.mapSize = (heroLv - 1) * 5 + 10 - (heroLv % 2);
        }
        Random monster = new Random();
        villain = monster.nextInt(5);

        if(villain == 1){
            this.monster = new Monster();
        }

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    @Override
    public String toString() {
        return "Map{" +
                "x=" + x +
                ", y=" + y +
                ", monster=" + monster +
                '}';
    }

    public Map[] createMap(Hero hero){
        Map[] tile = new Map[Globals.mapSize * Globals.mapSize];

        for(int i = 0; i < Globals.mapSize * Globals.mapSize; i++)
            tile[i] = new Map(1, false);

        for(int i = 0; i < Globals.mapSize * Globals.mapSize; i++) {
            tile[i].setX(i / Globals.mapSize + 1);
        }

        for(int i = 0; i < Globals.mapSize * Globals.mapSize; i++) {
            tile[i].setY(i % Globals.mapSize + 1);
        }

//        for(int i = 0; i < Globals.mapSize * Globals.mapSize; i++) {
//            System.out.println(tile[i].toString());
//        }
        hero.setX(Globals.mapSize / 2);
        hero.setY(Globals.mapSize / 2);
        return tile;
    }
}

