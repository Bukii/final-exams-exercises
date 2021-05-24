package at.htlle;

import java.util.Scanner;

public class Main 
{
	public static Scanner consInput = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		Gladiator playerOne = createPlayer();
		Gladiator playerTwo = createPlayer();

		//Create Weapon Shop and show price List
		GameItemShop shop = new GameItemShop();
		System.out.println(shop.itemList[0].getName());
		System.out.println("Things you can buy in my secret shop:");
		System.out.println(shop.getPriceList());
		
		//Player one Buys a weapon
		buyWeapon(playerOne, shop);
		
		//Player two buys a weapon
		buyWeapon(playerTwo, shop);
		
		fight(playerOne, playerTwo);
		
		
	}
	
	public static void fight(Gladiator playerOne, Gladiator playerTwo)
	{
		while (true)
		{
			int valOne = playerOne.attack();
			int valTwo = playerTwo.defend();
			System.out.println(playerOne.getName() + " attacks " + playerTwo.getName());
			
			if (valOne > valTwo)
			{
				System.out.println(playerOne.getName() + " wins");
				playerTwo.decreaseLifePoints(valOne - valTwo);
				System.out.println(playerTwo.getName() + " has now " + playerTwo.getLifePoints() + " Points");
				if (playerTwo.isDead())
				{
					System.out.println(playerTwo.getName() + " is dead");
					break;
				}
			}
			
			valTwo = playerTwo.attack();
			valOne = playerOne.defend();
			System.out.println(playerTwo.getName() + " attacks " + playerOne.getName());
			
			if (valTwo > valOne)
			{
				System.out.println(playerTwo.getName() + " wins");
				playerOne.decreaseLifePoints(valTwo - valOne);
				System.out.println(playerOne.getName() + " has now " + playerOne.getLifePoints() + " Points");
				if (playerOne.isDead())
				{
					System.out.println(playerOne.getName() + " is dead");
					break;
				}
			}
		}
	}
	
	public static Gladiator createPlayer()
	{
		System.out.println("Please enter your name");
		return new Gladiator(consInput.nextLine());
	}
	
	public static void buyWeapon(Gladiator player, GameItemShop shop)
	{
		Fightable weapon = null;
		do
		{
			System.out.println(player.getName() + " which weapon would you like to buy?");
			int weapon1 = Integer.parseInt(consInput.nextLine());
			weapon = (Fightable) shop.buyItem(weapon1,player.getMoney(shop.getPrice(weapon1)));
		}while (weapon == null);
			
		player.takeItem(weapon);
		System.out.println(player.getName() + " now has a " + player.getWeapon().getName());
	}
}