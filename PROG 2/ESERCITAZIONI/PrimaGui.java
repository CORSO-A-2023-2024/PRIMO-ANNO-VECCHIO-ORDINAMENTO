import java.awt.*;
import javax.swing.*;

public class PrimaGui{
	public static void main(String[] args){
		JFrame window = new JFrame("Uè uagliò");
		Container c = window.getContentPane();
		c.add(new JLabel("Esercitazione 3 Prog 2"));
		window.setSize(1000, 1000);
		//window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
	}
}