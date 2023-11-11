class Node {
	public int elem;
	public Node next;
	public Node(int elem, Node next) {
		this.elem = elem;
		this.next = next;
	}
	public String toString(){
		Node temp = this;
		String s = "";
		while(temp != null){
			s += temp.elem + " ";
			temp = temp.next;
		}
		
		return s;
	}
}
public class Ex2 {
	public static Node diff(Node p, Node q){
        if (p==null)
         return null;
        else if (q==null)
         return p;
        else if (q.elem<p.elem) //q.elem less than EVERY element of p:
      //q.elem is not in p, we remove q.elem
         return diff(p,q.next);
        else if (q.elem==p.elem) //p.elem occurs in the first position
      //of q: we remove p.elem
         return diff(p.next,q);
        else //p.elem<q.elem: p.elem less than EVERY element of q:p.elem
      //is not in q, we add p.elem to the result and we move to p.next
         return new Node(p.elem,diff(p.next,q));
    }
	
	public static void main (String[] args){
		Node p = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6, null))))));
		Node q = new Node(2, new Node(4, new Node(6, null)));
		Node r = diff(p, q);
		System.out.println(r);
	}
}