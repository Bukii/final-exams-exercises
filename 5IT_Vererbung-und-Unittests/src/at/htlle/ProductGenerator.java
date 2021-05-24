package at.htlle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductGenerator {

	private static final String[] firstnames = {"Baby Oil", "Bad News", "Big Burps", "Bill \"Beenie-Weenie\"",
		     "Bob \"Stinkbug\"", "Bowel Noises", "Boxelder", "Bud \"Lite\" ",
		     "Butterbean", "Buttermilk", "Buttocks", "Chad", "Chesterfield",
		     "Chewy", "Chigger", "Cinnabuns", "Cleet", "Cornbread", "Crab Meat",
		     "Crapps", "Dark Skies", "Dennis Clawhammer", "Dicman", "Elphonso",
		     "Fancypants", "Figgs", "Foncy", "Gootsy", "Greasy Jim", "Huckleberry",
		     "Huggy", "Ignatious", "Jimbo", "Joe \"Pottin Soil\"", "Johnny",
		     "Lemongrass", "Lil Debil", "Longbranch", "\"Lunch Money\"", "Mergatroid",
		     "\"Mr Peabody\"", "Oil-Can", "Oinks", "Old Scratch", "Ovaltine",
		     "Pennywhistle", "Pitchfork Ben", "Potato Bug", "Pushmeet",
		     "Rock Candy", "Schlomo", "Scratchensniff", "Scut",
		     "Sid \"The Squirts\"", "Skidmark", "Slaps", "Snakes", "Snoobs",
		     "Snorki", "Soupcan Sam", "Spitzitout", "Squids", "Stinky",
		     "Storyboard", "Sweet Tea", "TeeTee", "Wheezy Joe",
		     "Winston \"Jazz Hands\"", "Worms"};

	private static final String[] lastnames = {"Appleyard", "Bigmeat", "Bloominshine", "Boogerbottom",
		    "Breedslovetrout", "Butterbaugh", "Clovenhoof", "Clutterbuck",
		    "Cocktoasten", "Endicott", "Fewhairs", "Gooberdapple", "Goodensmith",
		    "Goodpasture", "Guster", "Henderson", "Hooperbag", "Hoosenater",
		    "Hootkins", "Jefferson", "Jenkins", "Jingley-Schmidt", "Johnson",
		    "Kingfish", "Listenbee", "M'Bembo", "McFadden", "Moonshine", "Nettles",
		    "Noseworthy", "Olivetti", "Outerbridge", "Overpeck", "Overturf",
		    "Oxhandler", "Pealike", "Pennywhistle", "Peterson", "Pieplow",
		    "Pinkerton", "Porkins", "Putney", "Quakenbush", "Rainwater",
		    "Rosenthal", "Rubbins", "Sackrider", "Snuggleshine", "Splern",
		    "Stevens", "Stroganoff", "Sugar-Gold", "Swackhamer", "Tippins",
		    "Turnipseed", "Vinaigrette", "Walkingstick", "Wallbanger", "Weewax",
		    "Weiners", "Whipkey", "Wigglesworth", "Wimplesnatch", "Winterkorn",
		    "Woolysocks"};
	
	public List<Book> bookGenerator(Integer num) {
		Random rand = new Random();
		
		List<Book> books = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			Integer fnxt = rand.nextInt(firstnames.length);
			Integer lnxt = rand.nextInt(lastnames.length);
			Integer year = rand.nextInt(2010 - 1900) + 1900;
			Float price = rand.nextFloat();
			books.add(new Book(i, price, "", firstnames[fnxt] + " " + lastnames[lnxt], year));
		}
		
		return books;
	}
	
	public List<DVD> dvdGenerator(Integer num) {
		Random rand = new Random();
		
		List<DVD> dvds = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			Integer fnxt = rand.nextInt(firstnames.length);
			Integer lnxt = rand.nextInt(lastnames.length);
			Float price = rand.nextFloat();
			dvds.add(new DVD(i, price, firstnames[fnxt] + " " + lastnames[lnxt], 10, 10));
		}
		
		return dvds;
	}
	
}
