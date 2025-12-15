// BasicMonster class
public class BasicMonster implements Monster{
    private String name;
    private int health;
    private Weapon weapon;

    public BasicMonster(String name, int health, Weapon weapon){
        this.name = name;
        this.health = health;
        this.weapon = weapon;
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
        int damage = 1 + (int)(Math.random() * (this.weapon.getMaxDamage()));
        enemy.takeDamage(damage);
        return this.name + " attacks " + enemy.getName() 
          + " with " + this.weapon.getName() 
          + " doing " + damage + " damage\n";
    }
}
