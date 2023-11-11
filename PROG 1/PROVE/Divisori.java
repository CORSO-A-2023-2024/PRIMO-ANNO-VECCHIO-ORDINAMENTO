public class Divisori{
	
	static void divisori(int n){
		int div = 0;
		for(int i = 1; i <= n; i++){
			if(n % i == 0){				
				System.out.print(i + " ");
			}
		}
	}
	
	static void MCD(int n, int m){
		int max = n < m ? m : n;
	    int div = 0;
		for(int i = 1; i <= max; i++){
			if(n % i == 0 && m % i == 0) div = i;
		}
		System.out.print(div);
	}
	
	public static void main(String[] args){
		int n = SavitchIn.readInt();
		int m = SavitchIn.readInt();
		MCD(n, m);
	}
}