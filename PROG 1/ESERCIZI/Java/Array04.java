public class Array04
{
	//Trovare i multipli di tre dai due vettori
	public static void main (String [] args)
	{
		int[] vec1={1,2,3,4};
		int[] vec2={2,5,1,9,10};
		boolean uguale=true;
		int aux=0;
		
		if(vec1.length!=vec2.length)
		{
			uguale=false;
		}
		for(int i=0; i<vec1.length &&uguale;i++)
		{
			if(vec1[i]!=vec2[i])
			{
				uguale=false;
			}
			if(vec1.length>vec2.length)
			{
				aux=vec1[i];
				vec2[i]=vec1[i];
				vec2[i]=aux;
			System.out.println(+aux);
			}
			
			
			
		}
		for(int i=0; i<vec1.length &&uguale;i++)
		{
			System.out.println(aux);
		}
		

		
	}
}