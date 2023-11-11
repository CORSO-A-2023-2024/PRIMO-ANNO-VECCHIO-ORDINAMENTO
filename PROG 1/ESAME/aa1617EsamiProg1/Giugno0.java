/**
 * ESAME PROGRAMMAZIONE 1 
 * Matricola: SCRIVERLA ORA!!!
 * Cognome: SCRIVERLO ORA!!!
 * Nome: SCRIVERLO ORA!!!
 * Corso: SCRIVERLO ORA!!!
 * Inoltre, SCRIVERE ORA nome, cognome, matricola, corso, NUMERO DEL PC sul foglio distribuito.
 * PER CONSEGNARE/RITIRARSI chiamare un docente.
 */
public class Giugno0 {
	
	/* ESERCIZIO 1 (Massimo 7 punti -- da consegnare elettronicamente).
	 * Scrivere un metodo iterativo di nome ex1 con le seguenti caratteristiche:
	 * --) 	ex1 ha due parametri formali di nome a e b. Entrambi sono riferimenti (puntatori, reference) 
	 * 	    a matrici di interi. Si assuma che le dimensioni di a e b siano  identiche.
	 *      Se a non contiene elementi, nemmeno b puo' contenerne;
	 * --) 	ex1 restituisce il true se esiste in a almeno una riga identica ad una di b.
	 *      In ogni altro caso il risultato e' false. 
	 * La classe Giugno0TestEx1 puo' essere usata per il testing di ex1, contenendo esempi sul 
	 * funzionamento atteso per ex1. 
	 * DOVE SCRIVERE ex1: qui sotto, immediatamente al di fuori di questo commento.  
	 */
	 
	 static boolean ex1(int[][] a, int[][] b){
		 boolean ris = false;
		 if(a != null && b != null){
			 if(a.length == 0 || b.length == 0 || a.length != b.length ){
				 ris = false;
			 }else{
				 int l = a.length;
				 for(int i = 0; i < l && !ris; i++){
					 if(a[i] != null){
						 boolean controllo = false;
						 for(int j = 0; j < b.length && !controllo; j++){
							 boolean ogni = true;
							 if(b[j] != null && a[i].length == b[j].length)
								 for(int e = 0; e < b[j].length && ogni; e++)
									ogni = a[i][e] == b[j][e];
							 else ogni = false;
							 controllo = ogni;
						 }
						 ris = controllo;
					}else ris = false;
				 }
			 }
		 }else{
			ris = false; 
		 } 
		 
		 return ris;
	 }
	 
	 /* ESERCIZIO 2 (Massimo 7 punti -- da consegnare elettronicamente).
	  * Scrivere un metodo ricorsivo di nome ex2 con le seguenti caratteristiche:
	  * --) ex2 ha come unico parametro formale un riferimento (puntatore, reference) 
	  * 	ad un array di interi di nome a;
	  * --) ex2 non restituisce nulla, ma modifica a come segue: 
	  *     se a non e' ne' vuota, ne' nulla, ogni elemento di posizione 
	  *     pari di a e' sovrascritto da quello di posizione dispari che, eventualmente, lo segue;
	  * --) ex2 richiama un metodo ricorsivo di nome "sovrascrive" che visita l'array a dicotomicamente, 
	  *     ovvero che, ad ogni chiamata, suddivide a in due parti di lunghezza essenzialmente identica.	  
	 * La classe Giugno0TestEx2 puo' essere usata per il testing di ex1, contenendo esempi sul funzionamento 
	 * atteso per ex2. 
	 * DOVE SCRIVERE ex2: immediatamente al di sotto di questo commento.  
	  */
	  
	  static void ex2(int[] a){
		  if(a != null || a.length > 0){
			  ex2(a,0,a.length-1);
		  }
	  }
	  
	  static void ex2(int[] a, int l, int r){
		  if(l == r){
			  a[l] = l % 2 == 0 ? a[l+1] : a[l];
		  }
		  int m = (l + r) / 2;
		  ex2(a,l,m);
		  ex2(a,m+1,r);
	  }
	 
	 /* ESERCIZIO 3 (Massimo 2 + 2 + 3 + 3 punti -- da consegnare a mano).
	  * Sia dato il metodo ex3 qui sotto definito.
	  * Assumendo che il parametro formale a sia diverso da null, lo scopo finale dell'esercizio
	  * e' dimostrare per induzione sul valore a.length-i che ex3 soddisfi:
	  * 
	  *    ex3(a,i) <==> esiste k (i <= k < a.length && a[k] == true)
	  * 
	  * Strutturare la soluzione in accordo con i seguenti punti:
	  * 1) scrivere esplicitamente il caso base per la dimostrazione (2 punti);
	  * 2) scrivere esplicitamente il caso induttivo per la dimostrazione (2 punti);
	  * 1) dimostrare che il caso base della dimostrazione per induzione e' vero (3 punti);
	  * 4) dimostrare che il caso induttivo della dimostrazione per induzione e' vero (3 punti).
	  */

	 static boolean ex3(boolean[] a,int i){
		if (i < a.length) 
			return (a[i] == true) || ex3(a,i+1);
		else 	
			return false;
	 }

	 /* ESERCIZIO 4 (Massimo 8 punti -- da consegnare a mano).
	  * Scrivere lo stato della memoria della JVM alla riga col commento // (B),
	  * ovvero giusto prima della disallocazione del frame relativo ad x.
	  */
	 public static void x(int[][] m,int[] a) {
		 int i;
		 for(i = 0; i < m.length; i++) {
			 m[i] = new int[a[i]];
			 m[i][0] = i;
		 }
		 // (B)
	 }
	 public static void main(String[] args) {
		 int [] a = {3,2,1};
		 int[][] m = new int[3][];
		 x(m,a);       // usare (A) come indirizzo per questa istruzione
	 }
}
