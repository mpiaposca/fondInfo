package catenanegozi;

import java.util.*;

public class Sistema 
{	private ArrayList<Negozio> negozi;
	private ArrayList<Acquisto> acquisti;

	public Sistema(ArrayList<Negozio> negozi, ArrayList<Acquisto> acquisti) 
	{	this.negozi = new ArrayList<Negozio>(negozi);
		this.acquisti = new ArrayList<Acquisto>(acquisti);
	}

	public ArrayList<String> negoziPreferiti(int data)
	{	ArrayList<String> ret = new ArrayList<>();
		int massimo = massimiAcquistiDataPerNegozio(data);
		for(Negozio n : negozi)
			if(acquistiNegozioData(n.getNome(), data) == massimo)
				ret.add(n.getNome());
		return ret;
	}
	
	private int massimiAcquistiDataPerNegozio(int data)
	{	int massimo = 0;
		for(Negozio n : negozi)
		{	int numAcquisti = acquistiNegozioData(n.getNome(), data);
			if(numAcquisti > massimo)
				massimo = numAcquisti;			
		}
		return massimo;
	}
	
	private int acquistiNegozioData(String nomeNegozio, int data)
	{	int c = 0;
		for(Acquisto a : acquisti)
			if(a.getNomeNegozio().equals(nomeNegozio))
				c++;
		return c;		
	}
	
	public ArrayList<String> clientiEsterniPeriodo(int dataInizio, int dataFine)
	{	ArrayList<String> ret = new ArrayList<>();
		ArrayList<String> CFClienti = codiciFiscaliClienti();
		for(String CF : CFClienti)
			if(!acquistatoCittaResidenza(CF, dataInizio, dataFine))
				ret.add(CF);
		return ret;
	}
	
	private ArrayList<String> codiciFiscaliClienti()
	{	ArrayList<String> ret = new ArrayList<>();
		for(Acquisto a : acquisti)
			if(!ret.contains(a.getCFCliente()))	
				ret.add(a.getCFCliente());
		return ret;		
	}
	
	private boolean acquistatoCittaResidenza(String CF, int dataInizio, int dataFine)
	{	for(Acquisto a : acquisti)
		{	int dataAcquisto = a.getData();
			Negozio n = trovaNegozio(a.getNomeNegozio());
			if(a.getCFCliente().equals(CF) && dataAcquisto >= dataInizio && dataAcquisto <= dataFine 
					&& n.getCitta().equals(a.getCittaCliente())) 
				return true;
		}
		return false;
	}
	
	private Negozio trovaNegozio(String nome)
	{	for(Negozio n : negozi)
			if(n.getNome().equals(nome))
				return n;
		return null;		
	}
	
	public ArrayList<String> clientiCittaDiverse()
	{	ArrayList<String> ret = new ArrayList<>();
		ArrayList<String> CFClienti = codiciFiscaliClienti();
		for(String CF : CFClienti)
			if(acquistatoCittaDiverse(CF))
				ret.add(CF);
		return ret;
	}
	
	private boolean acquistatoCittaDiverse(String CF)
	{	ArrayList<String> cittaAcquisti = new ArrayList<>();
		for(Acquisto a : acquisti)
		{	if(a.getCFCliente().equals(CF))
			{	Negozio n = trovaNegozio(a.getNomeNegozio());
				String cittaAcquisto = n.getCitta();
				if(!cittaAcquisti.contains(cittaAcquisto))
					cittaAcquisti.add(cittaAcquisto);
				if(cittaAcquisti.size() == 2)
					return true;
			}
		}
		return false;
	}
}
