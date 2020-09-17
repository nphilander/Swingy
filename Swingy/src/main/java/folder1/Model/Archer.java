package folder1.Model;

public class Archer extends Hero{

    public Archer(String name) {
        this.name = name;
        this.level = 1;
        this.xp = 0;
        this.attack = 10;
        this.defense = 15;
        this.hitPoints = 25;
        Globals.originalAttack = 10;
        Globals.originalDefense = 15;
        Globals.originalHitPoints = 25;
        Globals.currentHitPoints = 25;
        this.weapon = 0;
        this.helm = 0;
        this.armor = 0;
    }

    @Override
    public String toString() {
        return "Archer{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", xp=" + xp +
                ", attack=" + attack +
                ", defense=" + defense +
                ", hitPoints=" + hitPoints +
                ", weapon=" + weapon +
                ", helm=" + helm +
                ", armor=" + armor +
                '}';
    }
}
