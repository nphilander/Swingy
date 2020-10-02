package folder1.Controller;

import folder1.App;
import folder1.Model.Globals;
import folder1.Model.Hero;

import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Direction {

    public void dir(Hero hero, String str) throws InterruptedException {

        Globals.previousX = hero.getX();
        Globals.previousY = hero.getY();

        String input;
        System.out.println("Directions are Up = w , Down = s, Left = a, Right = d on keyboard");

        Scanner userInput = new Scanner(System.in);
        if (str.equals("console"))
            input = userInput.next();
        else
            input = App.gui.getInput();

        switch (input) {
            case "w":
                hero.setY(hero.getY() + 1);
                System.out.println("You moved NORTH \n");
                break;
            case "s":
                hero.setY(hero.getY() - 1);
                System.out.println("You moved SOUTH \n");
                break;
            case "a":
                hero.setX(hero.getX() - 1);
                System.out.println("You moved WEST \n");
                break;
            case "d":
                hero.setX(hero.getX() + 1);
                System.out.println("You moved EAST \n");
                break;
            default:
                System.out.println("Button pressed should be  'a' / 'd' / 's' / 'w'\nPLEASE TRY AGAIN\n");
        }

         if(hero.getX() == 0 || hero.getY() == 0 || hero.getY() == Globals.mapSize + 1 || hero.getX() == Globals.mapSize + 1){
             System.out.println("You have reached the border: Game completed");
             new ReadFile().serializePlayer(hero);
             if (Globals.args.equals("gui"))
                 sleep(5000);
             System.exit(0);
         }

    }
}
