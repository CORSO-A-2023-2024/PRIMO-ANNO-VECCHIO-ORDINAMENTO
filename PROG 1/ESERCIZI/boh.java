public class boh{
	
	static int[][] creazioneMat2(int righe, int colonne){
		int [][] ris = new int[righe][colonne];
		for(int i = 0; i < righe; i++){
			for(int e = 0; e < colonne; e++)
				ris[i][e] = i*e;
		}
		return ris;
	}
	
	static int[][] creazioneMat3(int righe){
		int [][] ris = new int[righe][];
		int [] riga1 = {8,3,2,4,1,6,9,1};
		ris[0] = riga1;
		for(int i = 1; i < righe; i++){
			int length = ris[i-1].length-1;
			int [] riga = new int[length];
			for(int j = 0; j < length; j++)
				riga[j] = ris[i-1][j] + ris[i-1][j+1];
			ris[i] =  riga;
		}
		return ris;
	}
   
   public static void stampaMatrice(int[][] mat) {
        if (mat != null) {
            // Per ogni riga
            for (int i=0; i<mat.length; i++) {
                if (mat[i] != null) {
                    System.out.print("  {");
                    // Per ogni elemento sulla riga i
                    for (int j=0; j<mat[i].length; j++) {
                        if (j>0)
                            System.out.print(", ");
                        System.out.print(mat[i][j]);
                    }
                    System.out.println("}");                    
                }
                else
                    System.out.println("  null");
            }
        }
    }
	
	public static void main(String[] args){
		final int[][] mat1 = { {1,0,0}, {0,1,0}, {0,0,1} };
		int[][] m2 = creazioneMat2(10,10);
		int[][] m3 = creazioneMat3(8);
		stampaMatrice(m2);
		System.out.println();
 		stampaMatrice(m3);
	}
}