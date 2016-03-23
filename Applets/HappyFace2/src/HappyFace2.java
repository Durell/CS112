/**
 * File Name: HappyFace2.java
 *
 * Homework Problem: #2 (34)
 *
 * Programmers: Hannah Yun, Darell Smith 
 * Date Last Modified: 02/02/16
 */
 
import java.awt.*;
import java.applet.*;
import javax.swing.JApplet;
import java.awt.Graphics;

public class HappyFace2 extends Applet {
	
	public void init() {
	}

	public void paint(Graphics canvas) 
	{
		canvas.drawOval(100, 50, 200, 200);
		canvas.fillOval(155, 100, 20, 20);
		canvas.fillOval(230, 100, 20, 20);
		canvas.drawArc(150, 160, 100, 50, 0, 180);
	}
}
