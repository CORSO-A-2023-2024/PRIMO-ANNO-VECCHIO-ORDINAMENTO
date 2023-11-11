abstract class List {
	public abstract double eval(double x);
}
class Nil extends List {
	public double eval(double x) {
		return 0;
	}
}
class Cons extends List {
	private double elem;
	private List next;
	public Cons(double elem, List next) {
		this.elem = elem;
		this.next = next;
	}
	public double eval(double x){
		return this.elem + this.next.eval(x)*x;
	}
}

public class Ex3{
	public static void main(String[] args){
		List a = new Cons(1, new Cons(2, new Cons(3, new Nil())));
		System.out.println(a.eval(5));
	}
}