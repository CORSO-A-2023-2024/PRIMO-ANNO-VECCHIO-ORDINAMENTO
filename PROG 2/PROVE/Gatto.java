class Gatto{
	public String nome;
	public int anni;
	public String razza;
	/*public String toString(){
	return "nome = " + nome + "\nrazza = " + razza + "\nanni = " + anni;
	// il parametro this è implicito
	}*/
}
class GattoDemo{
	public static void main(String[] args){
		Gatto tramot = new Gatto();
		System.out.println(tramot); 
	}
}