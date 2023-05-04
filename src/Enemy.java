// Enemy.java
public class Enemy extends Character {
    public Enemy(String name, int health, int attack) {
        super(name, health, attack);
    }

    @Override
    public void attack(Character target) {
        int damage = this.attack;
        System.out.printf("%s attacks %s for %d damage!\n", this.name, target.name, damage);
        target.takeDamage(damage);
    }

    @Override
    public int getMaxHealth() {
        return 50;
    }
}
