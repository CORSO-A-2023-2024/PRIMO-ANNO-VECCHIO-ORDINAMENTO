public class Simulazione {
	/** ESERCIZIO 1. 
	 * Scrivere un metodo iterativo e1 con le seguenti 
	 * caratteristiche:
	 * -) e1 ha un parametro formale di tipo matrice 
	 * bidimensionale di interi che puo' essere solo 
	 * quadrata, o nulla.
	 * -) e1 restituisce true quando:
	 *    a) la matrice non e' nulla e
	 *    b) la somma degli elementi di ciascuna riga 
	 *    concide con la somma degli elementi della 
	 *    colonna corrispondente. */
	 
	 static boolean e1(int[][] m){
		 boolean quadrata = true;
		 for(int i = 0; i < m.length && quadrata; i++) quadrata = m[i].length == m[0].length;
		 
		 if(quadrata || m == null){
			return false; 
		 }else{
			int sommaRiga = 0;
			int sommaColonna = 0;
			boolean ris = true;
			int i = 0;
			int j = 0;
			//Ciclo for per trovare la somma degli elementi della riga
			for(i = 0; i < m.length && ris; i++){
				for(j = 0; j < m[i].length; j++){
					sommaRiga += m[i][j];
					sommaColonna += m[j][i];
					ris = sommaRiga == sommaColonna;
				}
			}
			return ris;
		 }
	 }
	
	/** ESERCIZIO 2. 
	 * Scrivere un metodo ricorsivo dicotomico e2 con 
	 * le seguenti caratteristiche:
	 * -) e2 ha un parametro formale di tipo matrice 
	 * bidimensionale di interi che puo' essere solo 
	 * quadrata, o nulla.
	 * -) e2 restituisce true quando:
	 *    a) la matrice non e' nulla e
	 *    b) la somma degli elementi di ciascuna riga 
	 *    concide con la somma degli elementi della 
	 *    colonna corrispondente. 
	 * Per il calcolo della somma degli elementi in 
	 * una riga, definire un metodo ricorsivo sommaR 
	 * co-variante. Per il calcolo della somma degli 
	 * elementi in una colonna, definire un metodo 
	 * ricorsivo sommaC contro-variante.           */	
	 
	 static boolean isQuadrata(int[][] m, int i){
		 if(m == null){
			 return false;
		 }else{
			 if(i == m.length){
				 return true;
			 }else{
				 return m[i].length == m[0].length && isQuadrata(m, i+1);
			 }
		 }
	 }
	 
	 static int sommaR(int[] a, int i){
		 if(i == 0){
			 return a[i];
		 }else{
			 return a[i] + sommaR(a, i-1);
		 }
	 }
	 static int sommaC(int[] a, int i){
		 if(i == a.length-1){
			 return a[i];
		 }else{
			 return a[i] + sommaC(a, i+1);
		 }
	  }
	 
	 static boolean e2R(int[][] m, int l, int r){
		 if(l == r){
			 return sommaR(m[l], m[l].length-1) == sommaC(m[l], 0);
		 }else{
			 int med = (l+r)/2;
			 return e2R(m,l,med) && e2R(m,med+1,r);
		 }
	 }
	 static boolean e2(int[][] m){
		  if(isQuadrata(m,0) || m == null){
			return false; 
		 }else{
			return e2R(m, 0, m.length-1);
		 }
	 }
	

	
	
	
	
	
	
	
	
	/** ESERCIZIO 3. 
     * Siano dati:
     * -) il metodo parity, qui sotto definito, 
     * da applicare esclusivamente ad un parametro 
     * attuale con almeno un elemento (a.length>=1)
     * -) il predicato P(i) seguente:
     *
     *  "Alla sua uscita, parity(a,i) rende vero 
     *    'per ogni k.se 0<= k <= i, \
     *                allora a[k]==(k%2==0)' ".
     *
     * 1) Scrivere il predicato P(0).
     * 2) Scrivere il predicato P(i-1) ==> P(i).
     * 3) Dimostrare che P(0) e' vero.
     * 4) Dimostrare che P(i-1) ==> P(i) e' vero, 
     * ragionando induttivamente.                */ 	
	static void parity(boolean[] a, int i) {
		if (i < a.length) {
			if (i == 0)
				a[i] = true;
			else {
				parity(a, i - 1); //(A)
				a[i] = !a[i - 1]; //(B)
			}
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	/** ESERCIZIO 4. Disegnare lo stato della 
	 * memoria immediatamente prima della 
	 * disallocazione del record di attivazione 
	 * del metodo stack, quando i ha valore 2. */
	static void stack(int[][] x, int i) {
		if (i < x.length) {
			int[] l = new int[x[i].length];
			l[i] = x[i][i] + 1;
			x[i] = l;
			stack(x, i + 1); // (B)
		}
	}

		//int[][] y = {{0,0}, {0,0}};
		//stack(y, 0); // (A)
	public static void main(String[] args) {
		int [][] m1 = {{1,2},{2,1}};
		int [][] m2 = {{1,2,3},{2,3,1},{3,1,2}};
		int [][] m3 = {{1,2,3},{2,3,1},{3,4,1}};
		
		int [][] m4 = {{1,2},{2,1}};
		int [][] m5 = {{1,2,3},{2,3,1},{3,1,2}};
		int [][] m6 = {{1,2,3},{2,3,1},{3,4,1}};
		
		System.out.println("TEST ESERCIZIO 1:");
		System.out.println(true == e1(m1));
		System.out.println(true == e1(m2));
		System.out.println(false == e1(m1));
		
		System.out.println("TEST ESERCIZIO 2:");
		System.out.println(true == e2(m4));
		System.out.println(true == e2(m5));
		System.out.println(true == e2(m6));
	}
}