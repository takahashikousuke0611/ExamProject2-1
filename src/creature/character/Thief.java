package creature.character;

import weapon.Weapon;

public class Thief extends Character {
    private boolean guard = false;

    public Thief(String name, int hp, Weapon weapon) {
        super(name, hp, weapon);
    }

    public boolean isGuard() {
        return guard;
    }

    public void setGuard(boolean guard) {
        this.guard = guard;
    }

    @Override
    public void attack(Creature target) {
        int damage = getWeapon().getDamage() * 2;
        target.setHp(target.getHp() - damage);
        System.out.println(getName() + "は素早く2回攻撃した！" + getWeapon().getName() + getWeapon().attackMessage() + target.getName() + "に" + damage + "のダメージを与えた！");
    }

    public void guard() {
        this.guard = true;
        System.out.println(getName() + "は身構えた！次の敵からの攻撃を無効化する！");
    }

    public void setHp(int hp) {
        if (this.guard) {
            System.out.println("しかし、" + getName() + "は攻撃を回避し、ダメージが入らなかった！");
            this.guard = false;
        } else {
            super.setHp(hp);
        }
    }
}