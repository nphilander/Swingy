package folder1.Model;

public class Hero {
    protected String name;
    protected int level;
    protected int xp;
    protected int attack;
    protected int defense;
    protected int hitPoints;
    protected int weapon;
    protected int helm;
    protected int armor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getWeapon() {
        return weapon;
    }

    public void setWeapon(int weapon) {
        this.weapon = weapon;
    }

    public int getHelm() {
        return helm;
    }

    public void setHelm(int helm) {
        this.helm = helm;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    @Override
    public String toString() {
        return "Hero{" +
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
