package catenanegozi;

//NOTA BENE: La traccia non richiede di scrivere questa classe.
public class Negozio 
{	private String nome;
	private String citta;
	
	public Negozio(String nome, String citta) 
	{	this.nome = nome;
		this.citta = citta;
	}
	
	public String getNome() 
	{	return nome;
	}
	
	public String getCitta() 
	{	return citta;
	}
	
	public boolean equals(Object o)
	{	if(o == null)
			return false;
		if(o == this)
			return true;
		if(!(o instanceof Negozio))
			return false;
		Negozio n = (Negozio)o;
		return nome.equals(n.nome);
	}
	
	public String toString() 
	{	return "Negozio [nome=" + nome + ", citta=" + citta + "]";
	}
}
