public class Array02
//Trovare il numero più grande e piccolo del vettore del suo elemento
{
	
	static int max(int[] a){
		if(a != null && a.length != 0)
			return max(a,0);
		else return 0;
	}
	
	static int max(int[] a, int i){
		int max = 0;
		if(i == a.length-1)
			return a[i];
		else{
			max = a[i] > max ? a[i] : max;
			return max(a,i+1);
		}
	}
	
	static int min(int[] a){
		if(a != null && a.length != 0)
			return min(a,0);
		else return 0;
	}
	
	static int min(int[] a, int i){
		int min = 0;
		if(i == a.length - 1)
			return a[i];
		else{
			min = a[i] > min ? min : a[i];
			return min(a,i+1);
		}
	}
	
	public static void main (String [] args)
	{
		int[] a = {6,7,9,19,23,34,56,87,32,65,768,879};
		int[] b = null;
		System.out.println(max(a));
		System.out.println(min(a));
	}
}