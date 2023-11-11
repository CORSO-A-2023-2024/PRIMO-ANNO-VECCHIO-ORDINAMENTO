class Davide{
    private boolean isGay = true;
    public String nome;
    public String cognome;
    public Davide(String nome, String cognome){
        this.nome = nome;
        this.cognome = cognome;
    }
    public boolean isGay(){
        return this.isGay;
    }
    public String toString(){
        String verdetto = isGay() ? "si" : "no, però sotto sotto si";
        return "Si chiama " + this.nome + " " + cognome + '\n' + "Eh " + verdetto + " Davide è una pussy";
    }
}
public class DavideDemo{
    public static void main(String[] args){
        Davide davide = new Davide("Davide", "Soggiorno");
        System.out.println("Io: Pc delle mie brame, chi è il più coglione del reame?");
        String verdettoPc = davide.isGay() ? "Davide" : "Sempre Davide";
        System.out.println("PC: Dammi un attimo");
        System.out.println("PC: ....");
        System.out.println("PC: Ecco il mio verdetto");
        System.out.println(verdettoPc);
        System.out.println("PC: Ma dimmi chi è Davide? Davide è veramente una pussy?");
        System.out.println("Io: " + davide);
    }
}