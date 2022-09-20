public class Esercitazione2 {

	/*
	 * Si scriva un metodo "rollup" che riceve in input un array l di lunghezza n
	 * (con n pari) e restituisce un array di lunghezza n/2 il cui i-esimo elemento
	 * è pari a l[2*i] + l[2*i+1]
	 * 
	 * 				 0  1  2  3  4  5       	 0  1  2
	 * Esempio: l = [1, 4, 0, 6, 7, 1] => 	r = [5, 6, 8]
	 */
	
	
	public static int[] rollup(int[] l) {
		int[] ris = new int[l.length / 2];
		for(int i=0; i<ris.length; i++)
			ris[i] = l[2*i] + l[2*i+1];
		return ris;
	}// rollup
	
	
	
	/*
	 * Si scriva un metodo "alternati" che riceve in input un array l e restituisce
	 * true se l'array contiene valori alternati pari e dispari, cioè non ci sono
	 * due elementi consecutivi entrambi pari o entrambi dispari, e false
	 * altrimenti.
	 * 				 0  1   2  3  4  5
	 * Esempio: l = [2, 7, 12, 5, 6, 9] => true 
	 * 			l = [2, 7, 11, 6, 9, 6] => false
	 */
	
	public static boolean alternati(int[] l) {
		boolean precedentePari = l[0]%2==0; 
		for(int i=1; i<l.length; i++) {
			boolean correntePari = l[i]%2==0;
			//if( precedentePari && correntePari || !precedentePari && !correntePari )
			if( precedentePari==correntePari )
				return false;
			//precedentePari = correntePari;
			precedentePari = !precedentePari;
		}
		return true;
	}// alternati
	
	/*
	 * Si scriva un metodo "costruisciArray" che riceve in input un array di interi
	 * V1 e restituisce un array di interi V2 di pari lunghezza, il cui generico
	 * elemento i è così ottenuto: 
	 * - Se la media degli elementi di V1 con indice maggiore o uguale a i è maggiore o uguale a V1[i],
	 * 		allora V2[i] è uguale a tale media.
	 * - Altrimenti, V2[i] è uguale alla differenza tra la somma degli elementi alla sinistra di V1[i]
	 * 	    e la somma degli elementi alla destra di V1[i] (ovviamente se non c'è nessun elemento 
	 * 	    alla destra o alla sinistra tale somma vale zero).
	 */
	
	//		0  1   2  3  4  5
	// l = [2, 7, 12, 5, 6, 9], i=2 => media(l,i) = (12+5+6+9)/4
	// 								=> somma(i,l) = 2+7 = 9
	//								=> somma(l,i) = 5+6+9 = 20
	
	// 5/2 = 2
	// 5.0/2 = 2.5
	// 5/2.0 = 2.5
	// 5.0/2.0 = 2.5
	
	public static int[] costruisciArray(int[] v1) {
		int[] v2 = new int[v1.length];
		
		for(int i=0; i<v2.length; i++) {
			int media = media(v1, i);
			if(media >= v1[i])
				v2[i] = media;
			else {
				int sommaSX = somma(i, v1);
				int sommaDX = somma(v1, i);
				v2[i] = sommaSX - sommaDX;
			}
		}// for
		return v2;
	}// costruisciArray
	
	public static int media(int[]v, int k) {
		int s = 0;
		for(int i=k; i<v.length; i++)
			s += v[i];
		int media = s / (v.length - k);
		return media;
	}// media
	
	public static int somma(int k, int[] v) {
		int s = 0;
		for(int i=0; i<k; i++) s += v[i];
		return s;
	}// somma
	
	public static int somma(int[] v, int k) {
		int s = 0;
		//for(int i=k+1; i<v.length; i++) s+=v[i];
		k++;
		for(; k<v.length; k++) s+=v[k];
		return s;
	}// somma
	
	public static int[] costruisciArray2(int[] v1) {
		int[] v2 = new int[v1.length];
		for(int i=0; i<v1.length; i++) {
			int somma = 0;
			for(int j=i; j<v1.length; j++) somma += v1[j];
			int media = somma/(v1.length - i);
			if(media >= v1[i]) v2[i] = media;
			else {
				int somma1 = 0;
				for(int j=0; j<i; j++) somma1 += v1[j];
				int diff = somma1 - somma + v1[i];
				v2[i] = diff;
			}
		}// for i
		return v2;
	}// costruisciArray2
	
	/*
	 * Si scriva un metodo "costruisciMatrice" che riceve una matrice di interi M e 
	 * restituisce una matrice di boolean M' della stessa dimensione di M, tale che 
	 * 		a. le celle di M' sulla cornice esterna contengono tutte il valore false e
	 * 		b. ogni altra cella M'[i,j] contiene il valore true se e solo se la somma 
	 *         delle celle adiacenti ad M[i,j] è uguale al valore di M[i,j].
	 * 
	 * Esempio: 
	 * 			M = 1 -2  3  4		=>	  	 M' = F	F F F
	 *              3  7 -4 -2                    F T F F
	 *              5  0  1  6                    F F T F
	 *              4  2 -3 -5                    F F F F
	 */

	// i=1, j=1, M[i,j]=7. M[i,j] = somma degli elementi adiacenti? 1-2+3+3-4+5+0+1 = 7

	public static boolean[][] costruisciMatrice(int[][] m) {
		boolean[][] ris = new boolean[m.length][m[0].length];
		for(int j=0; j<ris[0].length; j++) {
			ris[0][j] = false;
			ris[ris.length-1][j] = false;
		}
		for(int i=1; i<m.length-1; i++) {
			ris[i][0] = false;
			ris[i][ris.length-1] = false;
		}
		
		for(int i=1; i<ris.length-1; i++) {
			for(int j=1; j<ris[0].length-1; j++) {
				int somma = m[i-1][j-1] + m[i-1][j] + m[i-1][j+1] + m[i][j-1] + m[i][j+1] + m[i+1][j-1] + m[i+1][j] + m[i+1][j+1];
				/*if(somma == m[i][j])
					ris[i][j] = true;
				else
					ris[i][j] = false;*/
				ris[i][j] = somma==m[i][j];
			}// for j
		}// for i
		return ris;
	}// costruisciMatrice

	/* Si scriva un metodo "verificaMatrice" che riceve in ingresso una matrice di interi M e 
	 * restituisce true se e solo se le colonne pari sono ordinate in modo non crescente 
	 * e quelle dispari in modo non decrescente. 
	 *    
	 *    1 4 5 7 8 9 => crescente, non decrescente
	 *    1 4 5 5 8 9 => non decrescente
	 *    
	 *    9 6 4 2 1 0 => decrescente, non crescente
	 *    9 6 4 2 2 1 => non crescente
	 *    
	 * Esempio: 
	 * 			M1 = 7 -1  9 -3		=>		True
	 *               5  0  5  1
	 *               4  6  5  8
	 *               1  7 -2  8
	 *               
	 *          M2 = 7 -1  9 -3		=>		False (la colonna 1 non è non decrescente)
	 *               7  0  4  2
	 *               2 -2  1  6
	 *               0  5  1  7
	 *    
	 */
	
	public static boolean verificaMatrice(int[][] m) {
		for(int j=0; j<m[0].length; j++) {
			if(j%2==0) {
				for(int i=0; i<m.length-1; i++) {
					if(m[i][j] < m[i+1][j]) return false;
				}// for i
			} else {
				for(int i=0; i<m.length-1; i++) {
					if(m[i][j] > m[i+1][j]) return false;
				}// for i
			}
		}// for j
		return true;
	}// verificaMatrice
	

	
	public static void main(String[] arguments) {
		int[] l = {1, 4, 0, 6, 7, 1};
		//int[] l = new int[6];
		//l[0]=1; l[1]=4; l[2]=0; l[3]=6; l[4]=7; l[5]=1;
		System.out.print("l = ");
		stampa(l);

		int[] ris = rollup(l);
		System.out.print("rollup(l) = ");
		stampa(ris);
		
		System.out.println("---------------------------------------------");
		
		int[] l2 = {2, 7, 12, 5, 6, 9};
		System.out.print("l2 = ");
		stampa(l2);
		boolean flag = alternati(l2);
		System.out.println("alternati(l2) = " + flag);
		
		System.out.println("---------------------------------------------");
		
		int[][] m = { {1,-2,3,4}, {3,7,-4,-2}, {5,0,1,6}, {4,2,-5,-3} };
		System.out.println("m:");
		stampa(m);
		System.out.println();
		boolean[][] r = costruisciMatrice(m);
		System.out.println("costruisciMatrice(m):");
		stampa(r);
		
		System.out.println("---------------------------------------------");

		int[][] m1 = { {7,-2,9,-3}, {5,0,5,1}, {4,6,5,8}, {1,7,-2,8} };
		System.out.println("m1:");
		stampa(m1);
		System.out.println();
		System.out.println( "verificaMatrice(m1) = " + verificaMatrice(m1) );
		
		System.out.println("---------------------------------------------");

	}// main
	
	public static void stampa(int[] v) {
		for(int i=0; i<v.length; i++)
			System.out.print(v[i] + "  ");
		System.out.println();
	}// stampa
	
	public static void stampa(boolean[][] m) {
		for(int i=0; i<m.length; i++) {
			for(int j=0; j<m[0].length; j++)
				System.out.print("\t" + m[i][j]);
			System.out.println();
		}
	}// stampa
	
	public static void stampa(int[][] m) {
		for(int i=0; i<m.length; i++) {
			for(int j=0; j<m[0].length; j++)
				System.out.print("\t" + m[i][j]);
			System.out.println();
		}
	}// stampa
	
	
}// Esercitazione2
