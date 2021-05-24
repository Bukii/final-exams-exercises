package at.htlle;

public class Spear implements Buyable, Fightable {

	private Integer price = 15;
	private String name = "Spear";
	private Integer attack = 4000;
	private Integer defend = 500;

	@Override
	public int getPrice() {
		return this.price;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int attack() {
		return this.attack;
	}

	@Override
	public int defend() {
		return this.defend;
	}
	
}
