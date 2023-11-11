public class Gauss{
  public static double[][] creaMatrice(int i, int j){
    double[][] mat = new double[i][j];
    for(int e = 0; e < i; e++){
		for(int l = 0; l < j; l++){
			System.out.print("Inserisci un numero intero: ");
			mat[e][l] = SavitchIn.readInt();
			System.out.println();
		}
	}
	return mat;
  }
  
  static String toString(double[][] m){
		String ris = "";
		for(int i = 0; i <  m.length; i++){
			int j = 0;
			for(j = 0; j < m[i].length; j++){
				ris +=  Math.round(m[i][j]*100.0)/100.0 + "\t";
			}
			if(j == m[i].length){
				ris += "\n";
			}else{
				ris += ' ';
			}
		}
		return ris;
  }
  
  public static void gauss(double[][] mat){ //questo metodo cerca nella matrice un pivot, quando lo trova chiama il metodo riduci, e poi ne cerca un altro nella riga dopo
		boolean piv = false; //flag che determina se ho trovato il pivot e ho effettuato la riduzione per quel pivot
		for(int i = 0; i<(mat[0].length-1); i++){	//scorre le righe, ma si ferma dopo aver finito il quadrato n*m
			piv = false;
			for(int j = 0; !piv && j<mat[i].length; j++){ //scorro la riga finchè non trovo il pivot
				if(mat[i][j] != 0){ //se il numero è diverso da zero viene scelto come pivot
					riduci(i, j, mat); //il metodo riduci prende in imput le coordinate del pivot e la matrice da ridurre
					
					piv = true;//pivot trovato e riduzione effettuata
					System.out.println("RIDUZIONE N." + (i+1));
					System.out.println(toString(mat));
				}
			}
		}
		return;
	}
	
	public static void riduci(int i, int j, double[][] mat){//questo metodo fa due cose:
		double pivot = mat[i][j];
		for(int k = 0; k<mat[i].length; k++){
			mat[i][k] =(double)(mat[i][k]/pivot);	//divide tutta la riga del pivot per il suo valore --> pivot diventa 1			
		}
		
		for(int n = 0; n<mat.length; n++){//riduce le altre righe
			if(n != i){ //tutte tranne la riga del pivot
			double prod = mat[n][j]; //numero che andrà moltiplicato nelle formule tipo R2 = R2 - prod*R1
			for(int m = 0; m<mat[n].length; m++){
					mat[n][m] = (double)(mat[n][m] - (double)((prod)*(mat[i][m]))); //operazione di riduzione 
			}
			}
		}
	}
  
  public static void main(String[] args){
    System.out.print("Inserisci l'altezza: ");
	int i = SavitchIn.readInt();
	System.out.print("Inserisci la larghezza: ");
	int l = SavitchIn.readInt();
	double[][] mat = creaMatrice(i, l);
	System.out.println();
	System.out.println(toString(mat));
	gauss(mat);
	System.out.println(toString(mat));
  }
}