package folder1.Controller;

import folder1.App;
import folder1.Model.Globals;
import folder1.Model.Hero;
import folder1.Model.Monster;

import java.util.Random;
import java.util.Scanner;

public class Battle {

    public void fight(Hero hero, Monster monster) {
        System.out.println(hero.toString());
        System.out.println(monster.toString());

        if (run(hero)) {
            while (hero.getHitPoints() > 0 && monster.getHitPoints() > 0) {
                if (hero.getAttack() > monster.getDefense())
                    monster.setHitPoints(monster.getHitPoints() - hero.getAttack());
                else
                    monster.setHitPoints(monster.getHitPoints() - hero.getAttack() / 2);
                System.out.println("Hero attacked: " + monster.toString());
                if (monster.getHitPoints() <= 0) {
                    break;
                }
                if (monster.getAttack() > hero.getDefense()) {
                    hero.setHitPoints(hero.getHitPoints() - monster.getAttack());
                    Globals.currentHitPoints = Globals.currentHitPoints - monster.getAttack();
                } else {
                    hero.setHitPoints(hero.getHitPoints() - monster.getAttack() / 2);
                    Globals.currentHitPoints = Globals.currentHitPoints - monster.getAttack() / 2;
                }
                System.out.println("Monster attacked: " + hero.toString());
            }
            if (hero.getHitPoints() <= 0) {
                System.out.println("   YOU LOST!!!\n");
                System.exit(0);
            } else {
                System.out.println("   YOU WON!!!\n");
                experience(hero);
                dropArtifact(hero);
            }
        }
    }

    private void dropArtifact(Hero hero) {
        Scanner myScanner = new Scanner(System.in);
        int dropped;
        int artifactCategory;
        int randIncrease;

        Random num = new Random();
        dropped = num.nextInt(3);
        artifactCategory = num.nextInt(3);
        randIncrease = num.nextInt(10) + 1;

        if (dropped == 1) {
            if (artifactCategory == 0) {
                System.out.println("Armor received");

                System.out.println("Do you want to keep the Armor (Armor value is " + randIncrease + ")" + ": Y or press any character decline? ");
                String armor;
                if (Globals.args.equals("console"))
                    armor = myScanner.next();
                else
                    armor = App.gui.getInput();
                if (armor.equals("Y")) {
                    hero.setDefense(Globals.originalDefense + randIncrease);
                    hero.setArmor(randIncrease);
                    System.out.println("defence increased by " + randIncrease);
                } else
                    System.out.println("Artifact not acquired");
            }
            if (artifactCategory == 1) {
                System.out.println("Helm received");

                System.out.println("Do you want to keep the Helm (Helm value is " + randIncrease + ")" + ": Y or press any character decline?");
                String helm;
                if (Globals.args.equals("console"))
                    helm = myScanner.next();
                else
                    helm = App.gui.getInput();
                if (helm.equals("Y")) {
                    hero.setHitPoints(Globals.currentHitPoints + randIncrease);
                    hero.setHelm(randIncrease);
                    System.out.println("hp increased by " + randIncrease);
                } else
                    System.out.println("Artifact not acquired");

            }
            if (artifactCategory == 2) {
                System.out.println("Weapon received");

                System.out.println("Do you want to keep the Weapon (Weapon value is " + randIncrease + ")" + ": Y or press any character decline?");
                String weapon;
                if (Globals.args.equals("console"))
                    weapon = myScanner.next();
                else
                    weapon = App.gui.getInput();
                if (weapon.equals("Y")) {
                    hero.setAttack(Globals.originalAttack + randIncrease);
                    hero.setWeapon(randIncrease);
                    System.out.println("attack increased by " + randIncrease);
                } else
                    System.out.println("Artifact not acquired");
            }
        }

    }

    private void experience(Hero hero) {
        int xp;
        int levelForm;
        int stats;
        levelForm = hero.getLevel() * 1000 + (hero.getLevel() - 1) * (hero.getLevel() - 1) * 450;
        Random num = new Random();
        stats = num.nextInt(15) + 1;
        xp = num.nextInt(100) + 1;

        System.out.println("Experience gained is " + xp + "\n");
        hero.setXp(hero.getXp() + xp);

        if (hero.getXp() >= levelForm) {
            hero.setLevel(hero.getLevel() + 1);
            hero.setHitPoints(hero.getHitPoints() + stats);
            hero.setDefense(hero.getDefense() + stats);
            hero.setAttack(hero.getAttack() + stats);
            System.out.println("Hero reached level  " + hero.getLevel());
        }

    }

    private boolean run(Hero hero) {
        String log;
        int rand;
        Random random = new Random();
        rand = random.nextInt(2) + 1;

        System.out.println("Type 'yes' to fight : Type any character to run away");
        Scanner input = new Scanner(System.in);
        if (Globals.args.equals("console"))
            log = input.next();
        else
            log = App.gui.getInput();

        if (log.equals("yes")) {
            return true; // if the fight happens
        } else {
            if (rand == 2) {
                System.out.println("Running away allowed, return to previous spot");
                hero.setX(Globals.previousX);
                hero.setY(Globals.previousY);
                return false;
            } else {
                System.out.println("Running was NOT allowed. You have to fight");
                return true;
            }
        }
    }

}
