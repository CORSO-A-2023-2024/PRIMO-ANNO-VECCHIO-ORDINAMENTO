public class EserciziMatrici{
	
	static void stampaMatrice(int[][] m){
		for(int i = 0; i < m.length; i++){
			if(m[i] != null)
				for(int j = 0; j < m[i].length; j++){
					System.out.print(m[i][j] + " ");
				}
				System.out.println();
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
	
	static int[] clonaArray(int[] a){
		int [] ris = new int[a.length];
		if(a != null)
			for(int i = 0; i < a.length; i++){
				ris[i] = a[i];
			}
			
		return ris;
	}
	
	static int[][] initAlt(int[] matp, int[] matd, int numr){
		int[][] ris = new int[numr][];
		
		for(int i = 0; i < numr; i++){
			if(i % 2 == 0){
				ris[i] = clonaArray(matp);
			}else{
				ris[i] = clonaArray(matd);
			}
		}
		
		return ris;
	}
	
	static int contaElementi(int[][] m){
		int ris = 0;
		if(m != null)
			for(int i = 0; i < m.length; i++){
				if(m[i] != null)
					ris += m[i].length;
			}
		
		return ris;
	}
	
	static int[] linearizzaRighe(int[][] m){
		int length = contaElementi(m);
		int [] ris = new int[length];
		int pos = 0; //indica la posizione in ris[]
		
		if(m == null)
			return null;
		
		for(int e = 0; e < m.length; e++){
			if(m[e] != null)
				for(int j = 0; j < m[e].length; j++){
					ris[pos++] = m[e][j]; 
				}
		}
		
		return ris;
	}
	
	static String toString(int[][] m){
		String ris = "";
		for(int i = 0; i <  m.length; i++){
			int j = 0;
			for(j = 0; j < m[i].length; j++){
				ris +=  m[i][j] + " ";
			}
			if(j == m[i].length){
				ris += "\n";
			}else{
				ris += ' ';
			}
		}
		return ris;
		
	}
	
	static int maxRowLen(int[][] m){
		int ris = 0;
		if(m != null)
			for(int i = 0; i < m.length; i++){
				if(m[i] != null)
					ris = m[i].length > ris ? m[i].length : 0;
			}
		return ris;
	}
	
	static int[] sommaRighe(int[][] m){
		int[] ris = new int[m.length];
		int pos = 0;
		for(int i = 0; i < m.length; i++){
			int somma = 0;
			for(int j = i; j < m[i].length; j++){
				somma += m[i][j];
			}
			ris[i] = somma;
		}
		return ris;
	}
	
	public static void main(String[] args){
		int[] a1 = {3, 5, 7}, a2 = {2, 10, 8, 9}, a3 = {8};
		stampaMatrice(initAlt(a1, a2, 6));
		System.out.println();
		System.out.println(contaElementi(initAlt(a1, a2, 6)));
		stampaArrayInt(linearizzaRighe(initAlt(a1,a2,6)));
		System.out.println(toString(initAlt(a1,a2,6)));
		System.out.println(maxRowLen(initAlt(a1,a2,6)));
		stampaArrayInt(sommaRighe(initAlt(a1,a2,6)));
	}
}