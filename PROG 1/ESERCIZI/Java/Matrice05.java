public class Matrice05
{
	public static void main (String [] args)
	{
		int cont =1;
		boolean uguale =true;
		int [][] A ={
						{1,2,3},
						{4,5,6},
						{7,8,9}
					};
		int [][] B ={
						{2,3,4},
						{5,6,7},
						{1,8,9}
					};
		
		for(int i =0;i<A.length;i++)
		{
			//i=0
			for(int j=0; j<A[0].length;j++)
			{
				//j=1
				if(A[i][j]==B[i][j])
				{
					System.out.println("Sono uguali : "+A[i][j]);
				}
				
			}
		}
		for(int i =0;i<B.length;i++)
		{
			//i=0
			for(int j=0; j<B[0].length;j++)
			{
				//j=1
				if(A[i][j]!=B[i][j])
				{
					System.out.println("Sono diversi : "+B[i][j]);
				}
				
			}
		}
		
	}
}