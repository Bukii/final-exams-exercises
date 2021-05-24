package at.htlle;

import java.util.Random;

/**
 * Represents a gladiator with a name.
 * 
 * @author Lukas
 *
 */
public class Gladiator {

	private String name;
	private Integer lifePoints;
	private Fightable weapon;
	private Integer money;

	/**
	 * Constructor for the gladiator. When created, it assigns a name.
	 * 
	 * @param name The name of the gladiator
	 */
	public Gladiator(String name) {
		this.name = name;
		Random rand = new Random();
		do {
			this.lifePoints = rand.nextInt(55000);
		} while (this.lifePoints < 10000);
		do {
			this.money = rand.nextInt(50);
		} while (this.money < 15);
	}

	/**
	 * Get the name of this gladiator.
	 * 
	 * @return The name
	 */
	public String getName() {
		return name;
	}

	public int attack() {
		return this.weapon.attack();
	}

	public int defend() {
		return this.weapon.defend();
	}

	public void decreaseLifePoints(int i) {
		this.lifePoints -= i;
	}

	public Integer getLifePoints() {
		return this.lifePoints;
	}

	public boolean isDead() {
		return this.lifePoints <= 0;
	}

	public void takeItem(Fightable weapon2) {
		this.weapon = weapon2;
	}

	public Fightable getWeapon() {
		return this.weapon;
	}

	public int getMoney(int price) {
		if (this.money - price >= 0) {
			this.money -= price;
			return price;
		}
		return 0;
	}

}
