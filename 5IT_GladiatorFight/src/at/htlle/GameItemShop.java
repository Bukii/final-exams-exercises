package at.htlle;

public class GameItemShop {

	Buyable[] itemList = new Buyable[4];
	private Integer money = 0;

	public GameItemShop() {
		itemList[0] = new GoldenAxe();
		itemList[1] = new Sword();
		itemList[2] = new Spear();
		itemList[3] = new Chain();
	}

	public String getPriceList() {
		String output = "";
		int count = 0;
		for (Buyable b : itemList) {
			output += String.format(count + ": %-23s | %10d |%n", b.getName(), b.getPrice());
			count++;
		}
		return output;
	}

	public int getPrice(int weapon1) {
		return itemList[weapon1].getPrice();
	}

	public Fightable buyItem(int weapon1, int money) {
		if (money != itemList[weapon1].getPrice()) {
			return null;
		}
		this.money += money;
		return (Fightable) itemList[weapon1];
	}

}
