
/*
	Per fare questi esercizi bisogna scrivere sotto il testo dell'esercizio la solita riga
	public static void main(String[] args){
		// Il codice per risolvere l'esercizio
	}
	
	Una volta fatto l'esercizio si commenti il codice dalla riga del public.
*/

public class EserciziIterazioni {

//Esercizi con l'if

/*
	Esercizio 1:
	
	Prendere un numero da input ( con la classe Scanner o con SIn.readInt() ) 
	e valutare se quel numero è pari e dispari,
	Se è pari, si stampi true, se è dispari si stampi false.
	
*/
	/*
		//Soluzione es.1 
		public static void main(String[] args){
			System.out.println("Inserisci un numero"); 
			// Non l'ho richiesto, lo faccio per estetica
			int n = SIn.readInt();
			
			if(n % 2 == 0)
				System.out.println(true);
			else
				System.out.println(false);
		}
	*/

/*
	Esercizio 2:
	
	Prendere un numero da input ( con la classe Scanner o con SIn.readInt() )
	e valutare se quel numero è un multiplo di 5.
	Se è un multiplo si stampi il numero e la seguente frase "è un multiplo di 5", 
	altrimenti si stampi il numero e la frase "non è un multiplo di 5"

*/
	/*
		//Soluzione es.2
		public static void main(String[] args){
			System.out.println("Inserisci un numero");
			//Non l'ho richiesto, lo faccio per estetica
			
			int n = SIn.readInt();
			
			if(n % 5 == 0){
				System.out.println(n + " è un multiplo di 5");
			}else{
				System.out.println(n + " non è un multiplo di 5");
			}
		}
	*/

/*
	Esercizio 3:
	
	Prendere 2 numeri da input ( con la classe Scanner o con SIn.readInt() )
	e valutare se la somma di quei numeri è maggiore di 7.
	Se la somma è maggiore di 7 allora si stampi true, altrimenti si stampi false

*/
	/*
		//Soluzione es.3
		public static void main(String[] args){
			System.out.println("Inserisci 2 numeri");
			//Non l'ho richiesto, lo faccio per estetica
			
			int n = SIn.readInt();
			int m = SIn.readInt();
			
			if((n + m) > 7){
				System.out.println(true);
			}else{
				System.out.println(false);
			}
		}
	*/
/*
	Esercizio 4:
	
	Prendere un numero da input ( con la classe Scanner o con SIn.readInt() )
	e valutare se quel numero è compreso tra 0 e 9.
	Se il numero è compreso, si stampi il numero e la frase "è compreso tra 0 e 9",
	altrimenti si stampi il numero e la frase "non è compreso tra 0 e 9"

*/
	/*
		//Soluzione es.4
		public static void main(String[] args){
			System.out.println("Inserisci un numero");
			//Non l'ho richiesto, lo faccio per estetica
			
			int n = SIn.readInt();
			
			if(n > 0 && n < 9){
				System.out.println(n + " è compreso tra 0 e 9");
			}else{
				System.out.println(n + " non è compreso tra 0 e 9");
			}
		}
	*/

/*
	Esercizio 5:
	
	Prendere un numero da input ( con la classe Scanner o con SIn.readInt() )
	e valutare se quel numero è compreso tra 0 e 5 o tra 7 e 10.
	Se la condizione richiesta è vera, si stampi "Il numero è compreso", altrimenti
	si stampi "Il numero non è compreso"

*/
	/*
		//Soluzione es.5
		public static void main(String[] args){
			System.out.println("Inserisci un numero");
			//Non l'ho richiesto, lo faccio per estetica
			
			int n = SIn.readInt();
			
			if((n > 0 && n < 9) || (n > 7 && n < 10)){
				System.out.println("Il numero è compreso");
			}else{
				System.out.println("Il numero non è compreso");
			}
		}
	*/

//Esercizi con while

/*
	Esercizio 1:
	
	Scrivere un programma nel quale si stampi 5 volte la seguente frase 
	"Giorgia sei stupenda".

*/
	/*
		//Soluzione es.1
		public static void main(String[] args){
			int n = 0;
			while(n < 5){
				System.out.println("Giorgia sei stupenda");
				n++;
			}
		}
	*/

/*
	Esercizio 2:
	
	Scrivere un programma nel quale si stampi 10 volte la seguente frase 
	"Marco odia le donne ma le vuole scopare"

*/
	/*
	//Soluzione es.2
		public static void main(String[] args){
			int n = 0;
			while(n < 10){
				System.out.println("Marco odia le donne ma le vuole scopare");
				n++;
			}
		}
	*/

/*
	Esercizio 3:
	
	Scrivere un programma nel quale un numero n, che all'inzio vale 0.
	Mentre n è minore di 10: si stampi "Voglio tanto bene a Luis", se il numero
	n è dispari, altrimenti si stampi "Voglio tanto bene a Sbro"

*/
	/*
	//Soluzione es.3
		public static void main(String[] args){
			int n = 0;
			while(n < 10){
				if(n % 2 != 0){				
					System.out.println("Voglio tanto bene a Luis");
				}else{		
					System.out.println("Voglio tanto bene a Sbro");
				}
				n++;
			}
		}
	*/

/*
	Esercizio 4:
	
	Scrivere un programma nel quale un numero n, che all'inizio vale 0.
	Mentre n è minore di 13: si stampi "Voglio tanto bene ad Elena", se il 
	numero n è multiplo di 3, altrimenti si stampi "Voglio tanto bene a Marco"

*/
	/*
	//Soluzione es.4
		public static void main(String[] args){
			int n = 0;
			while(n < 13){
				if(n % 3 == 0){				
					System.out.println("Voglio tanto bene ad Elena");
				}else{		
					System.out.println("Voglio tanto bene a Marco");
				}
				n++;
			}
		}
	*/
/*
	Esercizio 5:
	
	Scrivere un programma nel quale un numero n, che all'inzio vale 1.
	Mentre il numero è minore o uguale a 10: si stampi il prodotto tra n e n+1

*/
	
		//Soluzione es.5
		public static void main(String[] args){
			int n = 0;
			while(n < 10){
				System.out.println(n * (n + 1));
				n++;
			}
		}
	

//Esercizi con for

/*
	Esercizio 1:
	
	Scrivere un programma nel quale si stampi 5 volte la seguente frase 
	"Giorgia sei stupenda".

*/
	/*
		//Soluzione es.1
		public static void main(String[] args){
			for(int i = 0; i < 5; i++){
				System.out.println("Giorgia sei stupenda");
			}
		}
	*/

/*
	Esercizio 2:
	
	Scrivere un programma nel quale si stampi 10 volte la seguente frase 
	"Marco odia le donne ma le vuole scopare"

*/
	/*
		//Soluzione es.2
		public static void main(String[] args){
			for(int i = 0; i < 10; i++){
				System.out.println("Marco odia le donne ma le vuole scopare");
			}
		}
	*/


/*
	Esercizio 3:
	
	Scrivere un programma nel quale un numero n, che all'inizio vale 0, 
	viene aumentato di uno per 10 volte. Stampare alla fine di questa 
	iterazione, il valore di n.

*/
	/*
		 //Soluzione es.3
		 public static void main(String[] args){
			for(int n = 0; n < 10; n++){
				System.out.println(n);
			}
		}
		
		// Ho fatto così perchè il "contatore" del ciclo for, per come
		// viene costruito il ciclo, aumenta di uno ogni volta. Per questo
		// stampo il "contatore".
	*/


/*
	Esercizio 4:
	
	Scrivere un programma nel quale un numero n, che all'inizio vale 0, 
	viene aumentato di uno per 6 volte  e ogni volta che viene fatta questa 
	operazione, si stampi il numero aumentato (Consiglio: nella condizione 
	del for, mettere il numero n minore di 6).
	
	Ps. HO SBAGLIATO IL CONSIGLIO

*/
	/*
		//Soluzione es.4
		public static void main(String[] args){
			for(int n = 0; n < 6; n++){
				System.out.println(n);
			}
		}
		
		// Questo esercizio è uguale a quello precendente solo che
		// è scritto in una maniera diversa
	*/


/*
	Esercizio 5:
	
	Scrivere un programma nel quale un numero n, che all'inizio vale 1, 
	viene aumentato di due, se il numero n è dispari, viene diminuito di uno,
	se il numero n è pari. Ogni volta che viene fatta questa operazione, si stampi
	il numero n. Queste operzioni devono essere ripetute per 9 volte 
	(Consiglio: nella condizione del for, mettere il numero n minore di 9).

	Ps. HO SBAGLIATO IL CONSIGLIO
*/
	/*
		//Soluzione es.5
		public static void main(String[] args){
			int n = 1;
			for(int i = 0; i < 9; i++){
				if(n % 2 != 0){
					n = n + 2;
				}else{
					n--;
				}
				System.out.println(n);
			}
		}
	*/

}