public class prog05{
 public static void main (String[] arg) {
 System.out.println ("x^2+5x+4=0 trova le soluzioni");
 double a,b,c,d,e;
 a=1;
 b=5;
 c=4;
 d= (-b + (Math.sqrt(Math.pow(b,2)-4*(a*c))))/(2*a);
 e=(-b - (Math.sqrt(Math.pow(b,2)-4*(a*c))))/(2*a);
 System.out.println ("La soluzione 1 e "+d);
 System.out.println ("La soluzione 2 e "+e);
 
 }
}