package folder1;

import folder1.Controller.Battle;
import folder1.Controller.Direction;
import folder1.Controller.ReadFile;
import folder1.Model.Archer;
import folder1.Model.Hero;
import folder1.Model.Map;
import folder1.Model.Swordsman;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Nokhwezi Kholane
 */

public class App
{
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        Hero hero;
        System.out.println("'1' for new player, '2' to load player");
        if (scanner.nextInt() == 1) {
            System.out.println("CHOOSE HERO\n'1' for Archer , '2' for Swordsman");
            if (scanner.nextInt() == 1) {
                System.out.println("Enter name");
                hero = new Archer(scanner.next());
            } else {
                System.out.println("Enter name");
                hero = new Swordsman(scanner.next());
            }
        }
        else
            hero = new ReadFile().deserializePlayer();
        validation(hero);
        Map map = new Map(hero.getLevel(), true);
        Direction direction = new Direction();
        Map[] maps = map.createMap(hero);
        Battle battle = new Battle();
        while (true) {
            System.out.println(hero.toString());
            direction.dir(hero);
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

    public static void validation(Hero hero) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Hero>> violations = validator.validate(hero);
        for (ConstraintViolation<Hero> violation : violations) {
            if (violation.getMessage() != null){
            System.out.println(violation.getMessage());
            System.exit(0);
            }
        }
    }
}
