package at.htlle.schach;

/**
 * Abstrakte Klasse für Schachfiguren
 * 
 * @author gue
 */
public abstract class Figur {
	public int spalte; // Wertbereich 0 bis 7 für die Spalten a bis h
	public int reihe; // Wertbereich 0 bis 7 für die Reihen 1 bis 8
	public char[][] board = new char[8][8]; // erster Index=Spalte, zweiter Index=Reihe

	private String spalten = "abcdefgh";
	private String reihen = "12345678";

	public Figur(String startpos, char figur) {
		// die Startposition muss eine Zeichenkette mit zwei Zeichen sein
		if (startpos.length() != 2) {
			throw new IllegalArgumentException("ungültige Startposition");
		}

		// Auslesen der Spalte und Reihe
		spalte = spalten.indexOf(Character.toLowerCase(startpos.charAt(0)));
		reihe = reihen.indexOf(startpos.charAt(1));

		if (spalte == -1 || reihe == -1) {
			throw new IllegalArgumentException("ungültige Startposition");
		}

		board[spalte][reihe] = figur;
	}

	/**
	 * Diese Methode muss von den abgeleiteten Klassen implementiert werden
	 * 
	 * @return
	 */
	public abstract String ermittleZiele();

	/**
	 * liefert eine Schachposition in der Notation a1; bis h8; oder eine leere
	 * Zeichenkette;
	 * 
	 * @param spalte   Spaltennummer
	 * @param reihe    Reihennummer
	 * @return Position der Figur
	 */
	//
	protected String position(int spalte, int reihe) {
		if (spalte < 0 || spalte > 7 || reihe < 0 || reihe > 7) {
			return ("");
		}
		board[spalte][reihe] = '*';
		return ("" + spalten.charAt(spalte) + reihen.charAt(reihe) + ";");
	}

	/**
	 * Zeigt die Figur und die erreichbaren Felder im Textmodus an
	 */
	public void showBoard() {
		// Inhalt des Felds board ausgeben
		ermittleZiele();
		System.out.println();
		for (int r = 7; r >= 0; r--) {
			System.out.print(r + 1 + " "); // Zeilenbeschriftung
			for (int s = 0; s < 8; s++) {
				char c = board[s][r];
				if (c == 0)
					c = ' ';
				System.out.print(c + " ");
			}
			System.out.println();
		}

		// A bis H ausgeben
		System.out.print("  ");
		for (int s = 0; s < 8; s++) {
			System.out.print(spalten.charAt(s) + " ");
		}
		System.out.println();
	}

}
