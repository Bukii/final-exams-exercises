package at.htlle.schach;
/**
 * Klasse für die Schachfigur 'Dame'
 */

// TODO: Implement Me !
public class Dame extends Figur {

	/**
	 * Konstruktor
	 * @param startpos
	 */
	public Dame(String startpos)
	{
		super(startpos, 'D');
	}

	/**
	 *  liefert eine Zeichenkette mit allen Positionen, die der
	 *  Springer ausgehend von der aktuellen Position erreichen kann
	 *  die Positionen sind durch ; voneinander getrennt, also z.B. "a1;c3"
	 */
	public String ermittleZiele()
	{
		String zuege = "";
		zuege += position(spalte + 1, reihe + 0);
		zuege += position(spalte + 0, reihe - 1);
		zuege += position(spalte - 1, reihe + 0);
		zuege += position(spalte - 0, reihe + 1);
		zuege += position(spalte + 1, reihe + 1);
		zuege += position(spalte + 1, reihe - 1);
		zuege += position(spalte - 1, reihe + 1);
		zuege += position(spalte - 1, reihe - 1);
		return (zuege.substring(0, zuege.length() - 1));
	}
	
}