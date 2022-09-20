package catenanegozi;

//NOTA BENE: La traccia non richiede di scrivere questa classe.
public class Acquisto 
{	private String nomeNegozio;
	private int data;
	private String CFCliente;
	private String cittaCliente;
	
	public Acquisto(String nomeNegozio, int data, String CFCliente, String cittaCliente) 
	{	this.nomeNegozio = nomeNegozio;
		this.data = data;
		this.CFCliente = CFCliente;
		this.cittaCliente = cittaCliente;
	}
	
	public String getNomeNegozio() 
	{	return nomeNegozio;
	}
	
	public int getData() 
	{	return data;
	}
	
	public String getCFCliente() 
	{	return CFCliente;
	}
	
	public String getCittaCliente() 
	{	return cittaCliente;
	}

	public boolean equals(Object o)
	{	if(o == null)
			return false;
		if(o == this)
			return true;
		if(!(o instanceof Acquisto))
			return false;
		Acquisto a = (Acquisto)o;
		return nomeNegozio.equals(a.nomeNegozio) && data == a.data &&
				CFCliente.equals(a.CFCliente) && cittaCliente.equals(a.cittaCliente);
	}

	public String toString() 
	{	return "Acquisto [nomeNegozio=" + nomeNegozio + ", data=" + data + ", CFCliente=" + CFCliente
				+ ", cittaCliente=" + cittaCliente + "]";
	}
}
