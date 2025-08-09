package folder1;

import folder1.Controller.Battle;
import folder1.Controller.Direction;
import folder1.Controller.ReadFile;
import folder1.Model.*;
import folder1.View.Gui;
import folder1.View.SetUp;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Nokhwezi Kholane
 */

public class App {
    public static Gui gui = new Gui();

    public static void main(String[] args) throws IOException, InterruptedException {
        Globals.args = args[0];
        if (Globals.args.equals("console"))
            runConsole(Globals.args);
        else if (Globals.args.equals("gui"))
            runGui(Globals.args);
        else {
            System.out.println("Please parse an argument between 'gui' and 'console' ");
        }
    }

    private static void validation(Hero hero) {
        ValidatorFactory factory = Validation.byDefaultProvider()
                .configure()
                .messageInterpolator(new ParameterMessageInterpolator()) // Critical change
                .buildValidatorFactory();

        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Hero>> violations = validator.validate(hero);
        for (ConstraintViolation<Hero> violation : violations) {
            if (violation.getMessage() != null) {
                System.out.println(violation.getMessage());
                System.exit(0);
            }
        }
    }
//CONSOLE VERSION
    private static void runConsole(String args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Hero hero = null;

        System.out.println("WELCOME TO SWINGY");
        System.out.println("GAME HAS STARTED ######## YOU MAY BEGIN!!");
        System.out.println("The Choice number is 1 or any number ******** \nCHOOSE wisely!!!");
        System.out.println("Choose '1' for new player   OR    Press any character to load existing player");
        if (scanner.nextInt() == 1) {
            System.out.println("CHOOSE HERO\n'1' for Archer , '2' for Swordsman");
            String str = scanner.next();
            if (str.equals("1")) {
                System.out.println("Enter name");
                hero = new Archer(scanner.next());
            } else if (str.equals("2")) {
                System.out.println("Enter name");
                hero = new Swordsman(scanner.next());
            }
            else {
                System.out.println("Error: Choose a hero");
                System.exit(0);
            }
        } else
            hero = new ReadFile().deserializePlayer();
        validation(hero);
        Map map = new Map(hero.getLevel(), true);
        Direction direction = new Direction();
        Map[] maps = map.createMap(hero);
        Battle battle = new Battle();
        //noinspection InfiniteLoopStatement
        while (true) {
            System.out.println(hero.toString());
            direction.dir(hero, args);
            for (Map m : maps) {
                if (m.getX() == hero.getX() && m.getY() == hero.getY())
                    if (m.getMonster() != null) {
                        int compareXP = hero.getXp();
                        battle.fight(hero, m.getMonster());
                        if (hero.getXp() != compareXP)
                            m.setMonster(null);
                    }
            }
        }
    }
//GUI VERSION
    private static void runGui(String args) throws IOException, InterruptedException {
        SetUp game = new SetUp();
        gui.game();

        Hero hero;

        System.out.println("WELCOME TO SWINGY");
        System.out.println("GAME HAS STARTED ######## YOU MAY BEGIN!!");
        System.out.println("The Choice number is 1 or any number ******** \nCHOOSE wisely!!!");
        System.out.println("Choose '1' for new player   OR    Press any character to load existing player");

        if (gui.getInput().equals("1")) {
            System.out.println("CHOOSE HERO\n'1' for Archer , '2' for Swordsman");
            if (gui.getInput().equals("1")) {
                System.out.println("Enter name");
                hero = new Archer(gui.getInput());
            } else {
                System.out.println("Enter name");
                hero = new Swordsman(gui.getInput());
            }
        } else
            hero = new ReadFile().deserializePlayer();
        validation(hero);
        Map map = new Map(hero.getLevel(), true);
        Direction direction = new Direction();
        Map[] maps = map.createMap(hero);
        Battle battle = new Battle();
        //noinspection InfiniteLoopStatement
        while (true) {
            System.out.println(hero.toString());
            direction.dir(hero, args);
            for (Map m : maps) {
                if (m.getX() == hero.getX() && m.getY() == hero.getY())
                    if (m.getMonster() != null) {
                        int compareXP = hero.getXp();
                        battle.fight(hero, m.getMonster());
                        if (hero.getXp() != compareXP)
                            m.setMonster(null);
                    }
            }
        }
    }

}




