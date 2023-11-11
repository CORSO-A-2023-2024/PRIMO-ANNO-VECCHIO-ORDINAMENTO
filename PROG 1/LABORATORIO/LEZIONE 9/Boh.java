public class Boh{
	
	public static int[] filtraMaggioriDi(int[] a, int inf){
		if(a != null)
			return filtraMaggioriDi(a,inf,a.length-1,0);
		else return null;
	}
	
	public static int[] filtraMaggioriDi(int[] a, int limiteInferiore, int i, int counter) {
		if (i == 0) {
			return new int[counter];
		} else {
			if (a[i] > limiteInferiore) {
				int[] vetr = filtraMaggioriDi(a, limiteInferiore, i - 1, counter + 1);
				vetr[counter] = a[i];
				return vetr;
			} else {
				int[] vetr = filtraMaggioriDi(a, limiteInferiore, i - 1, counter);
				return vetr;
			}
		}
	}
	static void stampaArrayInt(int[] intArray){
		stampaArrayInt(intArray, 0);
	}
	
	static void stampaArrayInt(int [] a, int i){
		if(i < a.length && a != null){
			System.out.print(a[i] + " ");
			stampaArrayInt(a,i+1);
		}else{
			System.out.println();
		}
	}
	public static void main(String[] args){
		int[] a = {1,2,3,4,5,11,7,8,9,10};
		int[] filtrato = filtraMaggioriDi(a,7);
		stampaArrayInt(filtrato);
	}
}