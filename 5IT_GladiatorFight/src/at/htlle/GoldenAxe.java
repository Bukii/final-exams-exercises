package at.htlle;

public class GoldenAxe implements Buyable, Fightable {
	
	private Integer price = 35;
	private String name = "GoldenAxe";
	private Integer attack = 7000;
	private Integer defend = 3000;

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
