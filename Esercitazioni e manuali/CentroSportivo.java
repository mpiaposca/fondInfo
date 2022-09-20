package centroSportivo;

import java.util.ArrayList;
import java.util.Collections;

/*
 * La classe CentroSportivo gestisce due liste di oggetti: una lista di tesserati
 * (istanze della classe Tesserato) ed una lista di servizi offerti (istanze della classe Servizio).
 * 
 */

public class CentroSportivo {
	
	private ArrayList<Tesserato> listaTesserati;
	private ArrayList<Servizio> listaServizi;
	
	public CentroSportivo(ArrayList<Servizio> listaServizi, ArrayList<Tesserato> listaTesserati) {
		//this.listaServizi = new ArrayList<>(listaServizi);
		//this.listaTesserati = new ArrayList<>(listaTesserati);
		
		// SAFE
		this.listaServizi = new ArrayList<>();
		for(Servizio s: listaServizi)
			this.listaServizi.add( new Servizio(s.getCodice(), s.getTurno(), s.getCostoSettimanale(), s.getNrPosti()) );
		
		this.listaTesserati = new ArrayList<>();
		for(Tesserato t: listaTesserati) {
			this.listaTesserati.add( new Tesserato(t.getNome(), t.getCognome(), t.getDataNascita(), t.getCf(), t.getCodiceTessera(), t.getDataScadenza()) );
		}
	}// Costruttore
	
	/* 
	 * public boolean aggiorna(String codiceFiscale, int codServizio, String mese, boolean[] settimane).
	 * Tale metodo deve preliminarmente verificare che esista un tesserato con codice codiceFiscale e 
	 * che ci sia disponibilità di posti per il servizio con codice codServizio. In caso contrario il 
	 * metodo restituisce false. 
	 * Altrimenti, il metodo aggiunge alla lista dei servizi usufruiti dal tesserato un nuovo Abbonamento con i
	 * dati forniti come parametri (codServizio, mese, settimane), aggiorna il numero di posti disponibili per
	 * quel servizio e restituisce true.
	 *   
	 */
	
	// mese = "Marzo",		settimane = {F, F, T, T}
	public boolean aggiorna(String codiceFiscale, int codServizio, String mese, boolean[] settimane) {
		Tesserato t = trovaTesserato(codiceFiscale);
		if(t==null) return false;
		Servizio s = trovaServizio(codServizio);
		if(s==null || /*s.getPostiOccupati()==s.getNrPosti()*/ s.getPostiLiberi()==0) return false;
		s.incrementaPostiOccupati();
		
		boolean[][] mesiSettimane = new boolean[12][4];
		for(int i=0; i<12; i++)
			for(int j=0; j<4; j++)
				mesiSettimane[i][j] = false;
		
		int i = Abbonamento.getIndiceMese(mese);
		for(int j=0; j<4; j++)
			mesiSettimane[i][j] = settimane[j];
		
		Abbonamento a = new Abbonamento(codServizio, mesiSettimane);
		t.aggiungiAbbonamento(a);
		return true;
	}// aggiorna
	
	private Tesserato trovaTesserato(String cf) {
		for(Tesserato t: listaTesserati)
			if(t.getCf().equals(cf))
				return t;
		return null;
	}// trovaTesserato
	
	private Servizio trovaServizio(int codice) {
		for(Servizio s: listaServizi)
			if(s.getCodice()==codice)
				return s;
		return null;
	}// trovaServizio

	/*   
	 * public ArrayList<Servizio> serviziOrdinati(). Tale metodo deve restituire l'elenco dei servizi offerti 
	 * dal centro sportivo, ordinati per turno secondo l'ordinamento 'senior' -> 'advanced' -> 'junior' ed a 
	 * parità di turno per costo mensile decrescente.
	 *   
	 */
	public ArrayList<Servizio> serviziOrdinati() {
		ArrayList<Servizio> ret = new ArrayList<>(listaServizi);
		Collections.sort(ret);
		return ret;
	}// serviOrdinati
	

	/*
	 * public int[][] reportIscritti (String mese). Tale metodo deve costruire una matrice di interi in cui ogni
	 * riga contiene il codice di una tessera ed il costo totale (complessivo, in base ai turni e alle settimane)
	 * speso dal tesserato nel mese fornito come parametro (mese).
	 *
	 */
	
	public int[][] reportIscritti(String mese) {
		int[][] report = new int[listaTesserati.size()][2];
		
		int rigaLibera = 0;
		
		for(Tesserato t: listaTesserati) {
			ArrayList<Abbonamento> listaAbbonamenti = t.getListaAbbonamenti();
			
			int totale = 0;
			for(Abbonamento a: listaAbbonamenti) {
				int settimane = a.getSettimaneCoperte(mese);
				Servizio s = trovaServizio(a.getCodiceServizio());
				int costoAbbonamento = settimane * s.getCostoSettimanale();
				totale += costoAbbonamento;
			}// for
			
			report[rigaLibera][0] = t.getCodiceTessera();
			report[rigaLibera][1] = totale;
			rigaLibera++;
			
		}// for
		
		// rigaLibera == report.length
		return report;
	}// reportIscritti

}// CentroSportivo