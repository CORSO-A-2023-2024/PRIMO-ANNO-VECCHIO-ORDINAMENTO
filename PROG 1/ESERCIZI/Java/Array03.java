public class Array03
//Tra due vettori vedere se sono uguali o diversi
{
	public static void main (String [] args)
	{
		int [] vec1={1,2,0};
		int [] vec2={1,2};
		boolean Uguale=true;
		if(vec1.length!=vec2.length)
		{
			Uguale=false;
		}
		for(int i = 0;i<vec1.length &&Uguale;i++)
		{
			if(vec1[i]!=vec2[i])
			{
				Uguale=false;
			}
		}
		
		if(Uguale)
		{
			System.out.print("Uguale");
		}
		else
		{
			System.out.print("Diversi");
		}
		
	}
}