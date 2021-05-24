package at.htlle.schach;
// Klasse für die Schachfigur 'Läufer'

// TODO: Implement Me !
public class Laeufer extends Figur {

	/**
	 * Konstruktor
	 * @param startpos
	 */
	public Laeufer(String startpos)
	{
		super(startpos, 'L');
	}

	/**
	 *  liefert eine Zeichenkette mit allen Positionen, die der
	 *  Springer ausgehend von der aktuellen Position erreichen kann
	 *  die Positionen sind durch ; voneinander getrennt, also z.B. "a1;c3"
	 */
	public String ermittleZiele()
	{
		String zuege = "";
		zuege += position(spalte + 1, reihe + 1);
		zuege += position(spalte + 1, reihe - 1);
		zuege += position(spalte - 1, reihe + 1);
		zuege += position(spalte - 1, reihe - 1);
		return (zuege.substring(0, zuege.length() - 1));
	}
	
}