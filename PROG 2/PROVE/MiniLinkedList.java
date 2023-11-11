public class Node {
	private int elem; private Node next;
	public Node(int elem, Node next){this.elem = elem;this.next = next;}
	public void setElem(int elem){this.elem = elem;}
	public int getElem(){return elem;}
	public Node getNext(){return next;}
	public void setNext(Node node){next = node;}
}

public class MiniLinkedList {
	 private Node first; private int size; 
	 // INVARIANTE DI CLASSE:(first punta a elemento n.0 della lista 
	 // concatenata)
	 // e (size = numero nodi accessibili da first)
	/** Costruttore della lista vuota con 0 elementi */
	public MiniLinkedList(){
	 first = null; size = 0;
	}
	public int size() {
	 return this.size;
	}
	/** Metodo privato node(i) = indirizzo del nodo V_i della lista V. 
	 Viene usato dalla classe per definire gli altri metodi
	 Non viene reso pubblico per evitare che dall'esterno sia
	 possibile modificare i nodi della classe senza aggiornare size
	 (-> per evitare information leak). */
	 
	private Node node(int i){
	 //controllo che V_i sia un nodo della lista
	 assert 0 <= i && i < size: "i non in [0,size-1]"; 
	 //creo una copia di first per non modificare l'originale
	 Node p = this.first; 
	 // il primo nodo lo consideriamo in posizione 0
	 for(int j = 0; j < i; j++){
		 p = p.getNext();
	 }
	 
	 return p;
	 //nel caso i=0, node(i) restituisce proprio p = first
	}
	
	public static void main(String[] args){
		MiniLinkedList n = new MiniLinkedList();
	}
}