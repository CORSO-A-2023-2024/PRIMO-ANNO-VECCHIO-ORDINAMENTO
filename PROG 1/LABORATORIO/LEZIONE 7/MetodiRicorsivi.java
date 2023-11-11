public class MetodiRicorsivi{
	
	//Esercizio 1
	public static int sommatoriaRicorsiv(int n){
		System.out.print("Metti un numero: ");
		int x = SIn.readInt();
		//caso base
		if(x != 0){
			return sommatoriaRicorsiv(x + n);
		}else{
			return n;
		}
	}
	
	public static int sommatoriaRicorsiv1(){
		System.out.print("Metti un numero: ");
		int x = SIn.readInt();
		int sp = 0;
		
		if(x == 0){
			return sp; //caso base
		}else{
			return sp + sommatoriaRicorsiv1(); //passo induttivo
		}
	}
	
	public static int sommatoriaRicorsiva(){
		return sommatoriaRicorsiv1();
	}
	
	//Esercizio 2
	
	public static boolean trovaCarattere(String a, char b){
		return	trovaCarattere(a, b, 0);
	}
	
	public static boolean trovaCarattere(String a, char b, int i){
		if(i == a.length()){
			return true;
		}else{
			if(a.charAt(i) == b){
				return true;
			}else{
				return trovaCarattere(a,b,i+1);
			}
		}
	}
	
	public static int contaCarattereW(String a, char b){
		return	contaCarattere(a, b, 0);
	}
	
	public static int contaCarattere(String a, char b, int i){
		if(i == a.length()){
			return 0;
		}else{
			if(a.charAt(i) == b){
				return 1 + contaCarattere(a,b,i+1);
			}else{
				return contaCarattere(a,b,i+1);
			}
		}
	}
	
	//Esercizio 3
	
	public static boolean palindroma(String a, int i){
		int length = a.length();
		char lettera = 'a';
		if(i == 0){ 
			//caso base
			return a.charAt(i) == a.charAt(length - 1);
		}else{
			//caso non banale
			trovaCarattere(a, a.charAt((length/2) - 1), i);
			return palindroma(a, i+1);
		}
	}
	
	public static boolean palindroma(String a){
		return palindroma(a,0);
	}
	
	//Esercizio 4
	public static char controlloCarattere(char ch){
		String consonanti = "bcdfghlmnpqrstvzBCDFGHLMNPQRSTVZ";
		String vocali = "aeiouAEIOU";
		boolean flag = false;
		char b = 'a';
		
		for(int i = 0; i < vocali.length() && !flag; i++){
			if(ch == vocali.charAt(i)){
				flag = true;
			}else{
				flag = false;
			}
			if(flag){
				b = '*';
			}
		}
		if(!flag){
			for(int i = 0; i < consonanti.length() && !flag; i++){
				if(ch == consonanti.charAt(i)){
					flag = true;
				}else{
					flag = false;
				}
				if(flag){
					b = '$';
				}
			}
		}
		if(!flag){
			b = '-';
		}
		
		return b;
	}
	
	public static String conversioneCaratteri(String a, int i){
		if(i == a.length()){
			return "";
		}else{
			char ch = a.charAt(i);
			String ris = "";
			ris += controlloCarattere(ch);
			return ris + conversioneCaratteri(a,i+1);
		}	
	}
	
	//Esercizio 5
	
	public static String stringaInversa(String a, int i){
		int length = a.length();
		if(i == length){
			return "";
		}else{
			char ch = a.charAt(length - i - 1);
			String ris = "";
			ris += ch;
			return ris + stringaInversa(a, i+1);
		}
	}
	
	//Esercizio 6
	
	/*//Punto 1
	
	public static String eliminaCarattere(String a, int i){
		char ch = a.charAt(i);
		if(i == a.length()){
			return a;
		}else{
			String ris = "";
			if(trovaCarattere(a.substring(0,i), ch)){
				return a.substring(0,i) + a.substring(i+1, a.length());
			}else{
				return ris += eliminaCarattere(a, i+1);
			}
		}
	}
	
	//Punto 2
	
	public static void permutazioniStringa(String s) {
		permutazioniStringa(s, 0, "");
	}
	public static void permutazioniStringa(String s, int i, String pref) {
		if (i >= s.length() && s.length() > 0)
			return;
		else if (s.length() == 0)
			System.out.println(pref);
		else {
			String s2 = eliminaCarattere(s, i);
			permutazioniStringa(s2, 0, pref + s.charAt(i));
			permutazioniStringa(s, i + 1, pref);
		}
	}*/
	
	//Soluzione del professore
	
	static String eliminaCarattere(String s, int pos){
		return eliminaCarattere(s,pos,0);
	}
	
	static String eliminaCarattere(String s, int pos, int runningIndex){
		if(runningIndex == s.length()){
			return "";
		}else{
			if(runningIndex != pos){
				return s.charAt(runningIndex) + eliminaCarattere(s,pos,runningIndex+1);
			}else{
				return eliminaCarattere(s,pos,runningIndex+1);
			}
		}
	}
	
	static void permutazioni(String s){
		//permutazioni(s, "");
		permutazioni2(s,"",0);
	}
	
	//Iterazione + ricorsione
	
	static void permutazioni(String s, String prefix){
		if(s.length() == 1){
			System.out.println(prefix + s);
		}else{
			for(int i = 0; i < s.length(); i++){
				permutazioni(eliminaCarattere(s,i), prefix + s.charAt(i));
			}
		}
	}
	
	static void permutazioni2(String s, String prefix, int runningIndex){
		if(s.length() == 1){
			System.out.println(prefix + s);
		}else{
			permutazioni2(eliminaCarattere(s,runningIndex), prefix + s.charAt(runningIndex),0);
			if(runningIndex < s.length()-1){
				permutazioni2(s, prefix , runningIndex+1);
			}
		}
	}
	
	public static void main(String[] args){
		String s = "ciao";
		//System.out.println(permutazione(s));
		permutazioni(s);
	}
	
}