package at.htlle;

public class Sword implements Buyable, Fightable {

	private Integer price = 30;
	private String name = "Sword";
	private Integer attack = 5000;
	private Integer defend = 1500;

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
