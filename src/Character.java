// Character.java
public abstract class Character {
    protected String name;
    protected int health;
    protected int attack;

    public Character(String name, int health, int attack) {
        this.name = name;
        this.health = health;
        this.attack = attack;
    }

    public abstract void attack(Character target);

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
        System.out.printf("%s takes %d damage! (%d/%d HP)\n", this.name, damage, this.health, this.getMaxHealth());
    }

    public int getHealth() {
        return this.health;
    }

    public int getMaxHealth() {
        return 100;
    }

    public boolean isDead() {
        return this.health <= 0;
    }

    public void showStatus() {
        System.out.printf("%s: %d/%d HP\n", this.name, this.health, this.getMaxHealth());
    }
}
