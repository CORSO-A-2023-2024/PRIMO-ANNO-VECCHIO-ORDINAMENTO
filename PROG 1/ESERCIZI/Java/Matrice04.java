public class Matrice04
{
	public static void main (String [] args)
	{
		int cont =1;
		boolean uguale =true;
		int [][] A={
				    {1,2,3},
					{4,5,6},
					{7,8,9}
					};
		int [][] B={
					{1,2,3},
					{4,5,6}
					};
		for(int i =0; i<B.length;i++)
		{
			for(int j=0;j<B[0].length;j++)
			{
				B[i][j]=cont;
				cont++;
			}
		}
		if(A.length==B.length)
		{
			if(A[0].length==B[0].length){
				for(int i =0; i<B.length;i++)
				{
					for(int j=0;j<B[0].length;j++)
					{
						if(A[i][j]!=B[i][j])
						{
							uguale=false;
						}
						
					}
				}
			}
			else
			{	
				uguale=false;
			}
		}
		else
		{
			uguale=false;
		}
		if(uguale)
		{
			System.out.println("Sono uguali");
		}
		else
		{
			System.out.println("Sono diversi");
		}
	}
}