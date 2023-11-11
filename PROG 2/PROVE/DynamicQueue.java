class Node{
	private int elem;
	private Node next;
	
	public Node(int elem, Node next){
		this.elem = elem;
		this.next = next;
	}
	
	public int getElem(){
		return this.elem;
	}
	
	public Node getNext(){
		return this.next;
	}
	
	public void setElem(int x){
		this.elem = x;
	}
	
	public void setNext(Node n){
		this.next = n;
	}
}

class DynamicQueue{
	private Node first;
	private Node last;
	
	public DynamicQueue(){
		first = last = null;
	}
	
	public String toString(){
		String s = "";
		Node temp = first;
		while(temp != null){
			s += temp.getElem() + " | | ";
			temp = temp.getNext();
		}
		return s;
	}
	
	public void enqueue(int x){
		Node node = new Node(x, null);
		if(first == null)
			first = last = node;
		else{
			last.setNext(node);
			last = node;
		}
	}
	
	public int dequeue(){
		return last.getElem();
	}
	
	public int size(){
		Node temp = first;
		int i = 0;
		while(temp != null){
			i++;
			temp = temp.getNext();
		}
		return i;
	}
	
	public int front(){
		return first.getElem();
	}
	
	public boolean empty(){
		return size() == 0;
	}
	
	public boolean contains(int x){
		Node temp = first;
		while(temp != null){
			if(temp.getElem() == x) return true; else temp = temp.getNext();
		}
		return false;
	}	
}