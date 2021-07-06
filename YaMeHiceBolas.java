//Hecho por Joel Santillan A01634748
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class YaMeHiceBolas extends JFrame{
	
	private int nivel,
				x1 = 50,
				y1 = 50,
				largo = 600;

	public YaMeHiceBolas() {
		super("YaMeHiceBolas");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(720,700);
		this.setLocationRelativeTo(null);//posiciona la pantalla en el centro
		this.nivel = Integer.parseInt(JOptionPane.showInputDialog("Escribe el nivel que deseas dibujar: "));
		this.setVisible(true);
	}
	
	
	public void pintaCirculos(Graphics g,int nivel, int x1, int y1, int largo) {//funcion recursiva
		if(nivel==0) {
			g.drawOval(x1, y1, largo, largo);
		}else {
			g.drawOval(x1, y1, largo, largo);//se dibuja el circulo de afuera y luego se decrementa las medidas para los siguientes circulos
			this.pintaCirculos(g, nivel-1, x1, y1+largo/4, largo/2);
			this.pintaCirculos(g, nivel-1, x1+largo/2, y1+largo/4, largo/2);
		}
	}
	
	public void pintaArbol(Graphics g, int nivel, int x1, int y1, int x2, int y2) {
		if(nivel==0) {
			g.drawLine(x1, y1, x2, y2);
		}else {
			g.drawLine(x1, y1, x2, y2);
			this.pintaArbol(g, nivel-1, x1, y1-100, x2-100,	y2+175);
			this.pintaArbol(g, nivel-1, x1, y1-200, x2+100,y2+75);
		}
	}
	
	public void dibujaTronco(Graphics g, int x1, int y1, int x2, int y2) {
		
	}
		
	
	public void paint(Graphics g) {//funcion de preparacion
		super.paint(g);
		this.pintaCirculos(g, this.nivel, this.x1, this.y1, this.largo);
		//this.pintaArbol(g, nivel, 360, 600, 360, 100);
	}

	public static void main(String[] args) {
		YaMeHiceBolas v1 = new YaMeHiceBolas();

	}

}
