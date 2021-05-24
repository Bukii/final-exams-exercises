package at.htlle.schach;

/**
 * Klasse, um die (Schach-)Züge eines Springers zu berechnen
 * 
 * @author gue
 */
public class Springer extends Figur
{
	/**
	 * Konstruktor
	 * @param startpos
	 */
	public Springer(String startpos)
	{
		super(startpos, 'S');
	}

	/**
	 *  liefert eine Zeichenkette mit allen Positionen, die der
	 *  Springer ausgehend von der aktuellen Position erreichen kann
	 *  die Positionen sind durch ; voneinander getrennt, also z.B. "a1;c3"
	 */
	public String ermittleZiele()
	{
		String zuege = "";
		zuege += position(spalte + 2, reihe + 1);
		zuege += position(spalte + 1, reihe + 2);
		zuege += position(spalte + 2, reihe - 1);
		zuege += position(spalte + 1, reihe - 2);
		zuege += position(spalte - 2, reihe + 1);
		zuege += position(spalte - 1, reihe + 2);
		zuege += position(spalte - 2, reihe - 1);
		zuege += position(spalte - 1, reihe - 2);
		return (zuege.substring(0, zuege.length() - 1));
	}
}
