package at.htlle;
import at.htlle.schach.Dame;
import at.htlle.schach.Laeufer;
import at.htlle.schach.Springer;

// testet die Springer-Klasse
public class WirSpielenSchach {
	public static void main(String[] args)
	{
		System.out.println(" --- Springer ---");
		System.out.println();

		Springer sp = new Springer("b1");
		System.out.println(sp.ermittleZiele());
		sp.showBoard();

		System.out.println();
		System.out.println();
		System.out.println(" --- Läufer ---");
		System.out.println();
		Laeufer l = new Laeufer("c1");
		System.out.println(l.ermittleZiele());
		l.showBoard();

		System.out.println();
		System.out.println();
		System.out.println(" --- Dame ---");
		System.out.println();
		Dame d = new Dame("d1");
		System.out.println(d.ermittleZiele());
		d.showBoard();
	}

}
