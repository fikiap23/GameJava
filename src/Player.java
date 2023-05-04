// Player.java
public class Player extends Character {
    private int level;
    private int experience;

    public Player(String name, int health, int attack) {
        super(name, health, attack);
        this.level = 1;
        this.experience = 0;
    }

    @Override
    public void attack(Character target) {
        int damage = this.attack;
        System.out.printf("%s attacks %s for %d damage!\n", this.name, target.name, damage);
        target.takeDamage(damage);

    }

    public int getLevel() {
        return this.level;
    }

    public int getExperience() {
        return this.experience;
    }

    public void gainExperience(int experience) {
        this.experience += experience;
        if (this.experience >= 100) {
            this.levelUp();
        }
    }

    private void levelUp() {
        this.level += 1;
        this.experience -= 100;
        this.attack += 5;
        System.out.printf("%s is now level %d!\n", this.name, this.level);
    }
}
