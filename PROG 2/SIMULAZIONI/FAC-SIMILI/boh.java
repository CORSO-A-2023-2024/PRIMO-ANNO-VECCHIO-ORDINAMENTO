interface I {
public void m1(J obj);
}
interface J {
public void m2(I obj);
}
interface K {
public void m3();
}
class C implements I, J {
public void m1(J obj) {
obj.m2(this);
System.out.println("C.m1");
}
public void m2(I obj) {
obj.m1(this);
System.out.println("C.m2");
}
}
class D implements J, K {
public void m1(J obj)
{ System.out.println("D.m1"); }
public void m2(I obj)
{ System.out.println("D.m2"); }
public void m3() {
m1(this);
System.out.println("D.m3");
}
}

public class boh{
	public static void main(String[] args){
		I obj = new C();
obj.m1(new D());

	}
}
