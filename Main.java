import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        // Monster Battle!!!!!
        ArrayList<Monster> monsters = new ArrayList<Monster>();
        monsters.add(new BasicMonster("Bob", 100, new Weapon("sword", 12)));
        monsters.add(new BasicMonster("Rob", 100, new Weapon("spear", 13)));
        monsters.add(new BasicMonster("Job", 100, new Weapon("battle axe", 15)));
        monsters.add(new MultiAttackMonster("Jimmy Two Shoes", 100, new Weapon("daggers", 10), 2));
        monsters.add(new MultiAttackMonster("Timmy The Shadow", 100, new Weapon("brass knuckles", 6), 4));
        monsters.add(new CrazyMonster(100));

        while (aliveMonsters(monsters) > 1) {
            // battle it out!
            for (int i = 0; i < monsters.size(); i++) {
                Monster attacker = monsters.get(i);
                // must be alive
                if (attacker.getHealth() < 1) { // dead
                    continue;
                }
                // find enemy at random
                Monster enemy = getRandomEnemy(monsters, i);
                if (enemy == null) { // no more enemies
                    break;
                }
                // attack enemy and print attack result
                System.out.println(attacker.attack(enemy));
            }
        }

        Monster winner = getWinner(monsters);
        if (winner != null) {
            System.out.println("!!! " + winner.getName() + " wins!!!");
            System.out.println(winner.getName() + " won with " + winner.getHealth() + " health left!");
        } else {
            System.out.println("All monsters perished, none survived... 😢");
        }

    }

    public static Monster getWinner(ArrayList<Monster> monsters){
        for (Monster monster : monsters) {
            if (monster.getHealth() > 0) {
                return monster;
            }
        }
        return null;
    }

    public static int aliveMonsters(ArrayList<Monster> monsters) {
        int cnt = 0;
        for (Monster monster : monsters) {
            if (monster.getHealth() > 0) {
                cnt++;
            }
        }
        return cnt;
    }

    public static Monster getRandomEnemy(ArrayList<Monster> monsters, int attacker){
        // filter out dead monsters before picking enemy
        ArrayList<Integer> enemies = new ArrayList<Integer>();
        for (int i = 0; i < monsters.size(); i++) {
            if (i != attacker && monsters.get(i).getHealth() > 0) { // not attacker and is alive
                enemies.add(i);
            }
        }
        if (enemies.isEmpty()) { // no more enemies
            return null;
        }
        int rand = (int)(Math.random() * enemies.size());
        return monsters.get(enemies.get(rand)); //return random monster
    }
}
