package folder1.Model;

import javax.validation.constraints.*;

public class Hero implements java.io.Serializable{
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    protected String name;

    @Min(value = 1 , message = "Value has to be 1 or greater")
    @Max(value = 10 , message = "Value had to be 10 or less")
    protected int level;

    @Max(value = 10000, message = "XP can go past 9000 depending on level")
    protected int xp;

    @NotNull(message = "Attack should not be empty")
    protected int attack;

    @NotNull(message = "Defense should not be empty")
    protected int defense;

    @NotNull(message = "HitPoints should not be empty")
    protected int hitPoints;

    @PositiveOrZero
    protected int weapon;

    @PositiveOrZero
    protected int helm;

    @PositiveOrZero
    protected int armor;

    @PositiveOrZero
    protected int x;

    @PositiveOrZero
    protected int y;


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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
