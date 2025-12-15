// MultiAttackMonster class
public class MultiAttackMonster implements Monster {
    private String name;
    private int health;
    private Weapon weapon;
    private int numberOfAttacks;

    public MultiAttackMonster(String name, int health, Weapon weapon, int attacks) {
        this.name = name;
        this.health = health;
        this.weapon = weapon;
        this.numberOfAttacks = attacks;
    }

    public String getName() {
        return this.name;   
    }

    public int getHealth() {
        return this.health;   
    }

    public void takeDamage(int damage) {
        this.health -= damage;   
    }
    
    public String attack(Monster enemy) {
        int damage = 0;
        // stringbuilder
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.numberOfAttacks; i++) {
            damage = 1 + (int)(Math.random() * (this.weapon.getMaxDamage()));
            enemy.takeDamage(damage);
            sb.append(this.name + " attacks " + enemy.getName()
              + " with " + this.weapon.getName() 
              + " doing " + damage + " damage\n");
        }
        return sb.toString();
    }
}
