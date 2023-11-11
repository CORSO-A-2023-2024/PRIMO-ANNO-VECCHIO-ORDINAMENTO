/* ESERCIZI della Lezione 09 delle dispense

Contiene anche versioni alternative di alcuni metodi (segnalate con "Lezione del 30/03/23") e alcune note relative alla lezione del 03/04/2023.

0.	void scriviOutput(Node p). Stampa una lista concatenata partendo dal nodo in cima alla lista andando indietro (quindi in ordine inverso). Adattate il metodo per stampare una pila della Lezione 08. scriviOutput(q) scrive: 10 20 30 40 andando a capo dopo ogni elemento. 
1.	int length(Node p). Calcola la lunghezza di una lista. Traversiamo la lista con un ciclo, aggiungendo uno ogni volta che troviamo un nodo non nullo. length(q) vale 4.
2.	int sum(Node p). Somma degli elementi di una lista. Traversiamo la lista con un ciclo, sommando tutti gli elementi che incontriamo e mantenendo il risultato in una variabile s. Finita la lista, s è la somma di tutti gli elementi della lista. sum(q) vale 10+20+30+40=100.
3.	int max(Node p). Massimo degli elementi di una lista non nulla (non definito per la lista vuota). Traversiamo la lista con un ciclo, mantendo in una variabile m il più grande degli elementi trovati. Alla fine della lista m è il massimo. max(q) vale 40. 
4.	boolean member(Node p, int x). Controlla se x dato compare in una lista p. Traversiamo la lista con un ciclo, e non appena troviamo x usciamo con risposta true. Se arriviamo alla fine della lista senza trovare x, restituiamo false. member(q,30) vale true e member(q,50) vale false.
5.	String toString(Node p). Restituisce una stringa con i nodi di p separati da uno spazio. toString(q) vale "10 20 30 40".
6.	boolean sorted(Node p). Verifica se una lista concatenata è ordinata in modo debolmente crescente. sorted(q) vale true, se p = {10,20,30,40,30,20,10} allora sorted(p) vale false.
7.	boolean equals(Node p, Node q). Verifica se due liste concatenate sono uguali: hanno gli stessi elementi nello stesso ordine. equals(q,q) vale true, se p = {10,20,30,40,30,20,10} allora equals(p,q) vale false.
*/

//NodeUtil.java: 
public class NodeUtil{
//0. STAMPA dei nodi della lista in ordine inverso (vedi Lez.08)
public static void scriviOutput(Node p){
 while (p!=null){
   System.out.println(p.getElem());
   p=p.getNext();
 }
}

//1. Length. Metodo che calcola la lunghezza di una lista.   
  public static int length(Node p){
   int l=0; 
   while (p !=null){
   //ogni volta che incontro un nodo incremento di 1 la lunghezza
     p=p.getNext(); 
     l++;
   } 
   return l;
  }
 
//versione ricorsiva
/* Lezione del 30/03/23 - NOTE: (1) è bene che il caso/i base della ricorsione sia/no esplicito/i e compaia/no all'inizio del metodo, quando possibile; (2) l'else non è necessario per il funzionamento del metodo, ma rende il codice più leggibile.
*/
  public static int length_rec(Node p){
    if (p==null) return 0; 
    else return 1 + length_rec(p.getNext());
  }
    
//Lezione del 30/03/23 - 
/* versione ricorsiva di coda 'length_rec_c': la chiamata ricorsiva è l'ultima operazione prima del return. Fa uso di parametro ausiliario che ha lo stesso scopo del contatore l della versione iterativa (con while). Volendo, un modo alternativo per inizializzare correttamente il parametro ausiliario è introdurre un metodo wrapper (il metodo wrapper rende trasparente la presenza del parametro ausiliario al codice client, cioè al main(), nel nostro caso):
  public static void length(Node p){
     return length_rec_c(p, 0);
  }
*/
public static int length_rec_c(Node p, int c){
    if (p==null) return c; 
    else return length_rec_c(p.getNext(), c+1);
}
  
//2. Sum. Somma degli elementi di una lista. 
  public static int sum(Node p){
    int s=0; 
    while (p !=null){
    //ogni volta che incontro un nodo ne aggiungo il contenuto alla 
    //somma
      s = s+p.getElem(); 
      p=p.getNext();
    }
    return s;
  }
  
//versione ricorsiva
  public static int sum_rec(Node p){
    if (p==null) return 0; 
    else return p.getElem() + sum_rec(p.getNext());
  }
  
//3. Max. Massimo degli elementi di una lista non nulla 
//(non definito per la lista vuota)
    public static int max(Node p){
     assert p!= null: "Err. Massimo di una lista vuota";
      int m=p.getElem(); 
      p=p.getNext();
      // m=massimo dei nodi gia' visti, all’inizio m=nodo in cima
      while (p !=null){
        // a ogni passo prendo il massimo tra m (max nodi gia' visti) 
        // e il nodo corrente. 
        m = Math.max(m, p.getElem()); 
        p=p.getNext();
      }
      //alla fine m e' il massimo tra tutti i nodi
      return m;
    }
  
/* versione ricorsiva: parto a confrontare gli elementi a partire dall'ultimo.
   ESERCIZIO: scrivere una versione ricorsiva che faccia i confronti come nella 
			  versione iterativa (con il while), cioè a partire dal primo elemento.
*/
  public static int max_rec_es(Node p, int m){
	  assert p != null: "Err. Massimo di una lista vuota";
	  
	  int m = p.getElem();
	  if(p.getNext() == null) return m;
  }


  public static int max_rec(Node p){
   assert p!= null: "Err. Massimo di una lista vuota";

    if (p.getNext()==null) return p.getElem(); 
    // nel caso base siamo sull'ultimo elemento: il suo next è null
    else return Math.max(p.getElem(),max_rec(p.getNext()));
  }

//4. Member. Metodo che controlla se x dato compare in una lista p. Problema con quantificatole esistenziale: appena trovo un elemento che soddisfa la proprietà di essere = a x, restituisco true.
  public static boolean member(Node p, int x){
     while (p !=null){
      //a ogni passo se trovo x restituisco "true"
      if (p.getElem()==x) return true; else p=p.getNext();
     }
    //se ho esaurito la lista senza trovare x allora x non c'e'
    return false;
  }
/* ESERCIZIO: fare la versione con un return solo (strutturata)  
 */
  
//versione ricorsiva. ESERCIZIO: provare a riscrivere questa versione ricorsiva senza guardare la soluzione.
  public static boolean member_rec(Node p, int x){
    if (p==null) return false;
    // se la lista è vuota non esiste un elemento = x
    // Ripensare al caso base per "tutti gli elementi sono
    // uguali a x". 
    else if (p.getElem()==x) return true;
         else return member_rec(p.getNext(),x);
  }

// 5. String toString(Node p) restituisce una stringa 
// con i nodi di p separati da spazi 
  public static String toString(Node p){
   String s = " ";
   while (p!=null){
      s=s+p.getElem()+" ";
      p=p.getNext();
   }
   return s;
  }


// 6. Sorted(Node p) verifica se una lista concatenata
// è ordinata in modo debolmente crescente
  public static boolean sorted(Node p){
   if (p==null) return true; //lista vuota: ordinata
   while (p.getNext()!=null){
     if (p.getNext().getElem()>p.getElem()) 
      return false; 
     //se (secondo elemento > primo elemento): lista non ordinata
     p=p.getNext();
   }
   //finita la lista, non c'e' un elemento > del seguente:lista 
   //ordinata
   return true; 
}

// 7. equals(Node p, Node q) verifica se due liste concatenate 
// sono uguali
public static boolean equals(Node p, Node q){
  while ((p!=null) && (q!=null)){
   if (p.getElem()!=q.getElem()) return false;
   //se trovo due elementi in posizioni uguali e diversi: p,q diverse
   p=p.getNext(); q=q.getNext();
  }
  //finito il while abbiamo p=null oppure q=null. Quindi: 
  //1. se p,q sono lo stesso indirizzo, allora p=q=null e p,q 
  //contenevano lo stesso numero di elementi uguali a due a due:
  //erano uguali
  //2. se p,q sono indirizzi diversi, allora uno e' null e l'altro no
  //quindi p,q avevano lunghezze diverse:
  //erano diversi
   return (p==q);   //in ogni caso e’ la risposta giusta 
}
    
 //Lezione del 30/03/23 - 
/* versioni alternative della 'equals': uso di una variabile booleana 'uguali' (detta anche "flag"), per avere un solo return.
NOTA: questo stile di programmazione con un solo return, detto "programmazione strutturata", è molto utile nel caso in cui si voglia provare la correttezza formale di un programma (a mano o con uno strumento, ovvero un debugger o un theorem prover). Tuttavia, anche lo stile con più return è da tenere in considerazione, poiché dà luogo a programmi più leggibili da parte di un umano e, a volte, più efficienti dal punto di vista del numero dei passi di computazione. Come al solito, occorre imparare tutti gli strumenti e sviluppare l'abilità di scegliere il migliore a seconda del contesto in cui ci si trova.
*/
 public static boolean equals_1(Node p, Node q){
  boolean uguali = true;
  if (length(p) != length(q)) uguali = false;
  /* Si noti che rispetto alla versione ufficiale delle dispense questo metodo è più costoso, perché scorre le liste una prima volta per calcolare le length e poi per fare i confronti. */
     
  while (uguali && (p != null)){
   // non c'è bisogno di controllare anche q:
   // perché?
   if (p.getElem() != q.getElem()) uguali = false;
   p=p.getNext(); q=q.getNext();
  }
  return uguali;   
 }

 //versione con 'uguali' più compatta
 public static boolean equals_2(Node p, Node q){
  boolean uguali = (length(p) == length(q));
  /* Si noti che rispetto alla versione ufficiale delle dispense questo metodo è più costoso, perché scorre le liste una prima volta per calcolare le length e poi per fare i confronti. */
     
  while (uguali && (p != null)){
   // non c'è bisogno di controllare anche q:
   // perché?
   uguali = uguali && (p.getElem() == q.getElem());
   p=p.getNext(); q=q.getNext();
  }
  return uguali;   
 }

 public static void main(String[] args) {
    System.out.println( "Main di prova per gli esercizi 0-7");
    System.out.println( "---------------------");

//aggiungo i nodi di q={10,20,30,40} a sinistra, dunque parto da 40
    Node q=new Node(40,null); q=new Node(30,q);q=new Node(20,q);
    q=new Node(10,q);
    System.out.println( "Lista q:");
    scriviOutput(q);
    System.out.println( "---------------------");

//aggiungo i nodi di p={10,20,30,40,30,20,10} a sinistra
    Node p=new Node(10,null); p=new Node(20,p); p=new Node(30,p);
    p=new Node(40,p); p=new Node(30,p); p=new Node(20,p); 
    p=new Node(10,p);
    System.out.println( "Lista p:");
    scriviOutput(p);

    System.out.println( "---------------------");
    System.out.println( "1. length(p) = "       + length(p));
    System.out.println( "1. length_rec(p) = "   + length_rec(p));
    System.out.println( "1. length_rec_c(p, 0) = "   + length_rec_c(p, 0));
    System.out.println( "---------------------");
    System.out.println( "2. sum(p) = "          + sum(p));
    System.out.println( "2. sum_rec(p) = "      + sum_rec(p));
    System.out.println( "---------------------");
    System.out.println( "3. max(p) = "          + max(p));
    System.out.println( "3. max_rec(p) = "     + max_rec(p));
    System.out.println( "---------------------");
    System.out.println( "4. member(p,30) = "    + member(p,30));
    System.out.println( "4. member(p,50) = "    + member(p,50));
    System.out.println( "4. member_rec(p,30) = "+ member_rec(p,30));
    System.out.println( "4. member_rec(p,50) = "+ member_rec(p,50));  
    System.out.println( "---------------------");
    System.out.println( "5. toString(q) = "     + toString(q));
    System.out.println( "5. toString(p) = "     + toString(p));
    System.out.println( "---------------------");
    System.out.println( "6. sorted(q) = "       + sorted(q));
    System.out.println( "6. sorted(p) = "       + sorted(p));
    System.out.println( "---------------------");
    System.out.println( "7. equals(p,q) = "     + equals(p,q));
    System.out.println( "7. equals(p,p) = "     + equals(p,p));
    System.out.println( "7. equals(q,q) = "     + equals(q,q));
    System.out.println( "7. equals(q,p) = "     + equals(q,p));
    System.out.println( "---------------------");
    System.out.println( "7. equals_1(p,q) = "     + equals_1(p,q));
    System.out.println( "7. equals_1(p,p) = "     + equals_1(p,p));
    System.out.println( "7. equals_1(q,q) = "     + equals_1(q,q));
    System.out.println( "7. equals_1(q,p) = "     + equals_1(q,p));
    System.out.println( "---------------------");
    System.out.println( "7. equals_2(p,q) = "     + equals_2(p,q));
    System.out.println( "7. equals_2(p,p) = "     + equals_2(p,p));
    System.out.println( "7. equals_2(q,q) = "     + equals_2(q,q));
    System.out.println( "7. equals_2(q,p) = "     + equals_2(q,p));
 }

}  
