public class Array01
//Mettere in ordine crescente i valori del vettore
	{ 
	
	public static void ordineCresc(int[] vec){
		for(int i = 0; i < vec.length-1; i++){
				int rec = vec[i]
				if(vec[i] > vec[i+1]){
					vec[i] = vec[i+1];
					vec[i+1] = rec;
				}
			}
	}
	
	public static void main(String[] args)
		{
			int[] vec = {6,754,567674,3536,5476,763,53};
			
			ordineCresc(vec);
			
			for(int e = 0; e < vec.length){
				System.out.print(vec[i] + " ");
			}
		}
	}
	