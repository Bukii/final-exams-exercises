package at.htlle;

public class Chain implements Buyable, Fightable {

	private Integer price = 20;
	private String name = "Chain";
	private Integer attack = 6000;
	private Integer defend = 2000;

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
