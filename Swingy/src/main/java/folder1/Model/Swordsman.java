package folder1.Model;

public class Swordsman extends Hero{

    public Swordsman(String name) {
        this.name = name;
        this.level = 1;
        this.xp = 0;
        this.attack = 15;
        this.defense = 20;
        this.hitPoints = 15;
        Globals.originalAttack = 15;
        Globals.originalDefense = 20;
        Globals.originalHitPoints = 15;
        Globals.currentHitPoints = 15;
        this.weapon = 0;
        this.helm = 0;
        this.armor = 0;
    }

    @Override
    public String toString() {
        return "Swordsman{" +
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
