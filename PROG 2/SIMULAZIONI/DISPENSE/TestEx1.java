public class TestEx1{
	public static <T> boolean inComune(Node<T> p, Node<T> q){
		if(p == null || q == null){
			return false;
		}else{
			return p.getElem().equals(q.getElem()) || inComune(p.getNext(), q.getNext());
		}
		
	}
	public static void main(String[] args){
		Node<Integer> p = new Node<Integer>(1, new  Node<Integer>(2, new Node<Integer>(3, null)));
		Node<Integer> q = new Node<Integer>(3, new Node<Integer>(1, new Node<Integer>(0, null)));
		System.out.println(inComune(p,q)); //dovrebbe dare true
	}
}