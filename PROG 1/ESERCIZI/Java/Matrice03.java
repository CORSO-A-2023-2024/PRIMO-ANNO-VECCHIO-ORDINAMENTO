public class Matrice03
{
	public static void main(String [] args)
	{
		int x,y;
		int A[][] ={{2,3},{3,2},{1,2}};
		int B[][] ={{1,2},{3,4},{5,6}};
		int C[][] = new int[3][2];
		for(x=0;x<3;x++)
		{
			for(y=0;y<2;y++)
			C[x][y] =A[x][y]*B[x][y];
		}
		for(x=0;x<3;x++)
		{
			for(y=0;y<2;y++)
			System.out.print(" "+C[x][y]);
			System.out.println(" ");
		}
	}
}