public class Matrice01
{//Somma di matrici
	public static void main (String [] args)
	{
		int x,y;
		int A [][] = {{5,6,3},{4,2,0},{6,1,3}};
		int B [][] = {{50,16,37},{45,12,8},{6,10,3}};
		int C [][] = new int[3][3];
		for(x=0;x<3;x++)
		{
			for(y=0;y<3;y++)
				C[x][y]=A[x][y]+B[x][y];
		}
		for(x=0;x<3;x++)
		{
			for(y=0;y<3;y++)
			System.out.print(" "+C[x][y]);
			System.out.println(" ");
		}
			
		
	}
}