package folder1.Model;

import java.util.Random;

public class Monster {
    private int attack;
    private int defense;
    private int hitPoints;


    public Monster() {
        Random random = new Random();
        this.attack = random.nextInt(10) + 1;
        this.defense = random.nextInt(15) + 1;
        this.hitPoints = random.nextInt(20) + 1;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "attack=" + attack +
                ", defense=" + defense +
                ", hitPoints=" + hitPoints +
                '}';
    }
}
