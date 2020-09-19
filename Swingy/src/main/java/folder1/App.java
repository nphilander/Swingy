package folder1;

import folder1.Controller.Battle;
import folder1.Controller.Direction;
import folder1.Model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    public static void main( String[] args ) {
        Battle fight = new Battle();
        Archer archer = new Archer("Jill");
        Map map = new Map(1, true);
        map.createMap();
        //      Archer archer = new Archer("jay");
        archer.setX(Globals.mapSize / 2);
        archer.setY(Globals.mapSize / 2);
        System.out.println(archer.toString());
        Direction direction = new Direction();
        for (int i = 0; i < 100; i++) {
            direction.dir(archer);
            System.out.println(archer.toString());
        }

//        fight.fight(archer , monster);

//        for(int i = 0; i <1000; i++) {
//            Monster monster = new Monster();
//            fight.fight(archer, monster);
//        }

    }
}
