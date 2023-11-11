// Figura.java
import java.awt.*;    //Abstract Window Toolkit (finestre grafiche)
import javax.swing.*; //estensione di awt per interfacce grafiche

class Figura {
  // Dichiariamo il metodo di disegno draw ma lo definiamo vuoto: 
  // serve solo per ricordarci di definire un metodo draw in ogni 
  // sottoclasse della classe Figura.
    public void draw(Graphics g){ /* disegna la figura vuota */ }
}
class Quadrato extends Figura {
  //Un quadrato e' definito dal suo lato
  private int x; 
  private int y; 
  private int lato; 
  static Color colore;
  // COSTRUTTORE di un quadrato
  public Quadrato(int x, int y, int lato, Color c){ this.lato = lato; this.x = x; this.y = y; this.colore = c;	}

  // OVERRIDE: RI-definiamo il metodo draw (vuoto in Figura) 
  // per disegnare una figura nel caso di un quadrato. 
  // Scegliamo il quadrato centrato nell'origine e orizzontale.
  // Scegliamo il colore arancio per le prossime linee in g.
  public void draw(Graphics g){ 
   g.setColor(colore);
   int m = lato / 2; 
   g.drawLine( x+m,  x+m, y-m,  y+m);   //disegno primo   lato in g
   g.drawLine(x-m,  x+m, y-m, y-m);   //disegno secondo lato in g
   g.drawLine(x-m, x-m,  y+m, y-m);   //disegno terzo   lato in g
   g.drawLine( x+m, x-m,  y+m,  y+m);   //disegno quarto  lato in g
 }
}

class Cerchio extends Figura {
 // Un cerchio e' definito dal suo raggio r
    private int x;
	private int y;
	private int raggio;
	static Color colore;
 // COSTRUTTORE di un quadrato
    public Cerchio(int x, int y, int raggio, Color c){ this.x = x; this.y = y; this.raggio = raggio; this.colore = c;}

// OVERRIDE: RI-definiamo il metodo draw per disegnare una figura
// in un oggetto grafico g, nel caso la figura sia un cerchio. 
// Disegnamo il cerchio nel rettangolo di angolo in basso a sinistra
// (-r, -r) e di dimensioni 2r x 2r. 
// Scegliamo il colore rosso per le prossime linee in g
 

 public void draw(Graphics g) {
   g.setColor(colore); 
   g.drawOval(-raggio,-raggio,  2*raggio,2*raggio);
 }

}

class Triangle extends Figura{
	private int x;
	private int y;
	private int b;
	private int h;
	private Color colore;
	
	public Triangle(int x, int y, int b, int h, Color c){
		this.x = x;
		this.y = y;
		this.b = b;
		this.h = h;
		this.colore = c;
	}
	
	public void draw(Graphics g) {
	   int m = b/2;
	   g.setColor(colore); 
	   g.drawLine(x,y,x-m,y);
	   g.drawLine(x,y,x+m,y);
	   g.drawLine(x-m,y,x,y-h);
	   g.drawLine(x+m,y,x,y-h);
	}
}
	
class Disegno extends JFrame { 
 /* Un "disegno" e' un JFrame con parte grafica = tutte le figure di   
  un array di figure */
 private Figura[] figure;
 //COSTRUTTORE basato sul costruttore della classe superiore JFrame
 public Disegno(Figura[] figure){
  super();               // Assegnamo tutti i parametri di un JFrame
  this.figure = figure;  // Aggiungiamo un array di figure
 }
public void paint(Graphics g) { //INIZIALIZZO g
 int w = this.getSize().width;  // base    di g
 int h = this.getSize().height; // altezza di g
 g.clearRect(0, 0, w, h);  // azzero  il contenuto di g
 g.translate(w/2,h/2); //traslo sistema di riferimento al centro di g

 //DISEGNO tutte le figure dell’array figure
 for(int i=0;i<figure.length;++i) figure[i].draw(g); 
}
//BINDING per il metodo draw. Quale metodo draw viene scelto? //Dipende dal tipo esatto di figura[i]. Se figura[i] ha tipo esatto
//Quadrato, allora viene scelto il metodo draw per i quadrati e non 
//il metodo draw per le figure (che sarebbe un metodo vuoto)
}

public class Esercizio3{
	public static void main(String[] args){ 
  int m=7,n=9; Figura[] figure = new Figura[2*n];
  //Array di n figure: all’inizio ogni figura vale null   
  //Assegnamo le n figure: scegliamo m quadrati e (n-m) cerchi
  //Possiamo farlo perche' quadrati e cerchi sono particolari figure
   for(int i = 0; i<m; i++) figure[i] = new Quadrato(0, 0, i*20, Color.red);
   for(int i = m; i<n; i++) figure[i] = new Cerchio(0,0, i*10, Color.blue);
   for(int i = n; i<2*n; i++) figure[i] = new Triangle(i*10,i*10, i*10, i*10, Color.yellow);

   //Definiamo un disegno con array di figure proprio “figure"
   Disegno frame = new Disegno(figure);//Jframe con array di figure

   //ESEMPI DI EREDITARIETA' (SENZA OVERRIDE) DALLA CLASSE JFRAME
   //Scegliamo di terminare la figura quando ne chiudiamo la finestra
   //(il metodo setDefaultCloseOperation viene ereditato da JFrame)
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   //Scegliamo la dimensione della finestra grafica: 
   //(il metodo setSize viene ereditato da JFrame)
   frame.setSize(600,600);
   // setVisible(true) rende il disegno visibile, inviando il metodo 
   // paint all’oggetto frame insieme con un oggetto grafico g: 
   //(il metodo setVisible viene ereditato da JFrame)
   frame.setVisible(true);
  }
}
