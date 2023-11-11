class Node<T> {
	public T elem;
	public Node<T> next;
	public Node(T elem, Node<T> next) {
		this.elem = elem;
		this.next = next;
	}
}


class Ex1{
	
	public static <T> boolean controlla(Node<T> p, Node<T> q) {
		if(p == null || q == null){
			return false;
		}else{
			return p.elem.equals(q.elem) || controlla(p.next, q.next);
		}
	}
	
	public static void main(String[] args){
		Node<Integer> p = new Node<>(1, new Node<>(2, new Node<>(3, null)));
		Node<Integer> q = new Node<>(4, new Node<>(2, new Node<>(5, new Node<>(4, null))));
		Node<Integer> s = new Node<>(6, new Node<>(8, new Node<>(9, null)));
		Node<Integer> r = null;
		
		System.out.println(controlla(p,q) == true); //true
		System.out.println(controlla(q,r) == false); //false
		System.out.println(controlla(p,s) == false); //false
		System.out.println(controlla(q,s) == false); //false
	}
}