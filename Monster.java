public interface Monster {
	public String getName();
	public int getHealth();
	public String attack(Monster other);
	public void takeDamage(int damage);
}
