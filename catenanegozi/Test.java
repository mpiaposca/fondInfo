package catenanegozi;

import IO.*;
import java.util.*;

//NOTA BENE: La traccia non richiede di scrivere né questa classe né il metodo main.
public class Test 
{	public static void main(String[] args)
	{	ArrayList<Negozio> negozi = new ArrayList<>();
		Negozio n = new Negozio("Negozio A", "Roma");
		negozi.add(n);
		n = new Negozio("Negozio B", "Roma");
		negozi.add(n);
		n = new Negozio("Negozio C", "Milano");
		negozi.add(n);
		
		ArrayList<Acquisto> acquisti = new ArrayList<>();
		Acquisto a = new Acquisto("Negozio A", 10, "ABCDEF", "Roma");
		acquisti.add(a);
		a = new Acquisto("Negozio A", 10, "GHIJKL", "Napoli");
		acquisti.add(a);
		a = new Acquisto("Negozio A", 10, "MNOPQR", "Palermo");
		acquisti.add(a);
		a = new Acquisto("Negozio B", 10, "MNOPQR", "Palermo");
		acquisti.add(a);
		a = new Acquisto("Negozio B", 20, "GHIJKL", "Napoli");
		acquisti.add(a);
		a = new Acquisto("Negozio C", 20, "MNOPQR", "Palermo");
		acquisti.add(a);
		a = new Acquisto("Negozio C", 20, "ABCDEF", "Roma");
		acquisti.add(a);
		
		Sistema s = new Sistema(negozi,acquisti);
		IO.println(s.negoziPreferiti(10));
		IO.println(s.clientiEsterniPeriodo(10,20));
		IO.println(s.clientiCittaDiverse());
	}
}
