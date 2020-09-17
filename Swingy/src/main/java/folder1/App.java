package folder1;

import folder1.Controller.Battle;
import folder1.Model.Archer;
import folder1.Model.Hero;
import folder1.Model.Monster;
import folder1.Model.Swordsman;

import java.util.Scanner;

public class App
{
    public static void main( String[] args ) {
        Battle fight = new Battle();
        Archer archer = new Archer("Jill");
//        String a = "hi";

//        fight.fight(archer , monster);

        for(int i = 0; i <100; i++) {
            Monster monster = new Monster();
            fight.fight(archer, monster);
        }

//        Scanner myScanner = new Scanner(System.in);
//        String test = myScanner.next();
//        System.out.println("word is " + test);

    }
}
