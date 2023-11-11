import java.util.Scanner;

public class IngressoDati
{
	public static void main (String [] args)
	{
		int a;
		System.out.println("Ingressa un numero : ");
		Scanner S = new Scanner(System.in);
		a = S.nextInt();
		System.out.println("Il tuo numero e' : "+a);
	}
}