package creature.character;

import weapon.Weapon;

public class Wizard extends Character {
    private int mp;

    public Wizard(String name, int hp, int mp, Weapon weapon) {
        super(name, hp, weapon);
        this.mp = mp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public void magic(Creature target) {
        if (this.mp < getWeapon().getCost()) {
            System.out.println("MPが足りない！");
            return;
        }
        this.mp -= getWeapon().getCost();
        int damage = getWeapon().getDamage();
        target.setHp(target.getHp() - damage);
        System.out.println(getName() + getWeapon().attackMessage() + target.getName() + "に" + damage + "のダメージを与えた！");
    }

    public void attack(Creature target) {
        int damage = 3;
        target.setHp(target.getHp() - damage);
        System.out.println(getName() + "は石を投げた！" + target.getName() + "に" + damage + "のダメージを与えた！");
    }

    public void showStatus() {
        System.out.println(getName() + " (HP:" + getHp() + "/MP:" + getMp() + ")");
    }
}