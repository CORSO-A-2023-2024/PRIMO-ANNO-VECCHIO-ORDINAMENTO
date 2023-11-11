public class DynamicQueue{
    
// un puntatore first al primo elemento della coda (il primo ad essere eliminato)
// e un puntatore last all’ultimo elemento della coda;
 Node first = null;
 Node last = null;
// (i) un costruttore per la coda vuota;
  public DynamicQueue(){
    first = last = null;
  }
// (ii) un metodo di scrittura;
  public String toString(){
    Node tmp = first;
    String ris = "";
    while(tmp != null){
      ris += tmp.getElem();
      ris = tmp.getNext() == null ? ris + '\n' : ris + ", "; 
      tmp = tmp.getNext();
    }
    return ris;
  }
// (iii) un metodo void enqueue(int x) per aggiungere un elemento dietro l’ultimo;
  public void enqueue(int x){
    Node node = new Node(x, null);
    if (empty()) // coda vuota
            first = last = node;
        else { // almeno un elemento
            last.setNext(node); // last -> node -> null
            last = node;
        }
  }
// (iv) un metodo int dequeue() per togliere il primo elemento della coda;
  public int dequeue() {
    assert !empty() : "Coglione cosa fai, è vuota la coda";
    int x = first.getElem();
    first = first.getNext();
    if (first == null)
      last = null;

    return x;
  }
// (v) un metodo int size() per contare gli elementi della coda;
  public int size(){
    Node tmp = first;
    int i = 0;
    while(tmp != null){
      i++;
      tmp = tmp.getNext();
    }
    return i;
  }
// (vi)  un metodo int front() per leggere il primo elemento della coda senza toglierlo;
// TODO aggiungere assert
  public int front(){
    assert !empty() : "Coglione, la lista è vuota";
    return first.getElem();
  }

// (vii) un metodo boolean empty() per verificare se la coda è vuota;
  public boolean empty(){
    return first == null && last == null;
  }
// (viii) un metodo pubblico boolean contains(int x) per verificare se la coda contiene un dato elemento x;
  public boolean contains(int x){
    Node tmp = first;
    boolean trovato = false;
    while(tmp != null && !trovato){
      trovato = tmp.getElem() == x;
      tmp = tmp.getNext();
    }
    return trovato;
  }

// Tutti i metodi devono preservare il seguente invariante della classe: ogni
// nodo tranne l’ultimo punta al precedente, e first e last puntano al primo e
// all’ultimo elemento della coda, inoltre sono uguali a null se la coda è
// vuota.
}

