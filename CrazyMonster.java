// CrazyMonster class
public class CrazyMonster implements Monster {
    private int health;
    private int attackStrength;
    private int damageCount;

    public CrazyMonster(int health){
        this.health = health;
        this.attackStrength = 0;
    }

    public String getName() {
        String c = "!@#$%^&*?";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int r = (int)(c.length() * Math.random());
            sb.append(c.charAt(r));
        }
        return sb.toString();
    }

    public int getHealth() {
        return this.health;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        damageCount++;
        if (damageCount % 2 == 0) {
            attackStrength += damage;
        }
    }
    
    public String attack(Monster enemy){
        int damage = 1 + (int)(Math.random() * (attackStrength));
        enemy.takeDamage(damage);
        return getName() + " attacks " + enemy.getName() 
          + " doing " + damage + " damage\n";
    }
}
