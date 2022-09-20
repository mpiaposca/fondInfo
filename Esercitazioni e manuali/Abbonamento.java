package centroSportivo;

/*
 * La classe Abbonamento è caratterizzata dai seguenti attributi: codice identificativo del servizio in
 * abbonamento e settimane in abbonamento (si suggerisce di rappresentare i mesi e le settimane come
 * matrice di booleani 12x4).
 */

/*
 *
 * Esempio matrice mesiSettimane:
 *
 * 	Gennaio  	->		0 |	F	F	F	F
 * 	Febbraio	->		1 |	F	T	T	T
 * 	Marzo		->		2 |	F	F	F	F
 *  Aprile		->		3 |	T	T	T	T
 *  Maggio  	->		4 |	F	F	F	F
 * 	Giugno		->		5 |	F	F	F	F
 * 	Luglio		->		6 |	F	F	T	T
 *  Agosto		->		7 |	T	F	T	F
 *  Settembre  	->		8 |	F	F	F	F
 * 	Ottobre		->		9 |	F	T	F	F
 * 	Novembre	->	   10 |	F	F	F	F
 *  Dicembre	->	   11 |	T	T	T	T
 *
 *
 */

public class Abbonamento {// Genera oggetti immutabili

	private static final String[] mesi = {"gennaio", "febbraio", "marzo", "aprile", "maggio", "giugno",
											"luglio", "agosto", "settembre", "ottobre", "novembre", "dicembre"};

	private int codiceServizio;
	private boolean[][] mesiSettimane;

	public Abbonamento(int codiceServizio, boolean[][] mesiSettimane) {
		this.codiceServizio = codiceServizio;
		this.mesiSettimane = new boolean[12][4];
		for(int i=0; i<12; i++)
			for(int j=0; j<4; j++)
				this.mesiSettimane[i][j] = mesiSettimane[i][j];
	}// Costruttore


	// GETTERS

	public int getCodiceServizio() {
		return codiceServizio;
	}

	public boolean[][] getMesiSettimane() {
		boolean[][] ris = new boolean[12][4];
		for(int i=0; i<12; i++)
			for(int j=0; j<4; j++)
				ris[i][j] = mesiSettimane[i][j];
		return ris;
	}// getMesiSettimane

	public boolean equals(Object o) {
		if(o==null) return false;
		if(this==o) return true;
		if(!(o instanceof Abbonamento))
			return false;

		Abbonamento a = (Abbonamento) o;
		if(codiceServizio!=a.codiceServizio) return false;
		for(int i=0; i<12; i++)
			for(int j=0; j<4; j++)
				if(mesiSettimane[i][j] != a.mesiSettimane[i][j])
					return false;
		return true;
	}// equals

	public static int getIndiceMese(String mese) {
		int i = -1;
		for(int k=0; k<mesi.length; k++)
			if(mesi[k].equalsIgnoreCase(mese)) {
				i = k;
				break;
			}
		return i;
	}// getIndiceMese

	public int getSettimaneCoperte(String mese) {
		int conta = 0;
		int indiceMese = -1;
		for(int i=0; i<mesi.length; i++) {
			if(mesi[i].equalsIgnoreCase(mese)) {// gennaio == GENNAIO == Gennaio == gEnNaIo
				indiceMese = i;
				break;
			}
		}// for

		for(int j=0; j<4; j++)
			if(mesiSettimane[indiceMese][j])
				conta++;

		return conta;
	}// getSettimaneCoperte

	// toString

}// Abbonamento














