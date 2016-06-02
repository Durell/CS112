/*
Chapter No. 18 - Project 3 (Page 1076)
File Name:          Moody.java
Programmer:         Durell Smith
Date Last Modified: May 18, 2016

Problem Statement:

*/

// imports
import javax.swing.JFrame;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.Graphics;
import java.awt.Color;

public class Moody extends JFrame
{

	public static final int WIDTH = 400;
	public static final int HEIGHT = 400;
	public static final int FACE_DIAMETER = 200;
	public static final int X_FACE = 100;
	public static final int Y_FACE = 100;
	public static final int EYE_WIDTH = 20;
	public static final int EYE_HEIGHT = 30;
	public static final int X_RIGHT_EYE = X_FACE + 55;
	public static final int Y_RIGHT_EYE = Y_FACE + 60;
	public static final int X_LEFT_EYE = X_FACE + 130;
	public static final int Y_LEFT_EYE = Y_FACE + 60;
	public static final int MOUTH_WIDTH = 100;
	public static final int MOUTH_HEIGHT = 25;
	public static final int X_MOUTH = X_FACE + 50;
	public static final int Y_MOUTH = Y_FACE + 135;
	public static boolean frown;

  public static void main(String[] args)
  {
  	Moody gui = new Moody();
  	gui.setVisible(true);
  }

  public Moody()
  {
  	super("Moody");
  	setSize(WIDTH, HEIGHT);
  	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  	getContentPane().setBackground(Color.white);
  	addWindowListener(new FrownAction());
  	frown = false;
  }

  private class FrownAction implements WindowListener
  {
    	// Switch between smile and frown
    	public void windowOpened(WindowEvent e)
			{}
			public void windowClosing(WindowEvent e)
			{}
			public void windowClosed(WindowEvent e)
			{}
			public void windowIconified(WindowEvent e)
			{}
			public void windowDeiconified(WindowEvent e)
			{}
			public void windowActivated(WindowEvent e)
			{
				frown = false;
    		repaint();
			}
			public void windowDeactivated(WindowEvent e)
			{
				frown = true;
	    	repaint();
			}
  }

  public void paint(Graphics g)
  {
  	super.paint(g);
  	g.setColor(Color.YELLOW);
  	g.fillOval(X_FACE, Y_FACE, FACE_DIAMETER, FACE_DIAMETER);
  	g.setColor(Color.BLACK);
  	g.drawOval(X_FACE, Y_FACE, FACE_DIAMETER, FACE_DIAMETER);
		//Draw Eyes:
		g.fillOval(X_RIGHT_EYE, Y_RIGHT_EYE, EYE_WIDTH, EYE_HEIGHT);
		g.fillOval(X_LEFT_EYE, Y_LEFT_EYE, EYE_WIDTH, EYE_HEIGHT);
		//Draw Mouth:
		if (frown)
		{
			g.drawArc(X_MOUTH, Y_MOUTH, MOUTH_WIDTH, MOUTH_HEIGHT, 0, 180);
			g.drawArc(X_MOUTH, Y_MOUTH - 1, MOUTH_WIDTH, MOUTH_HEIGHT, 0, 180);
		}
		else
		{
			g.drawArc(X_MOUTH, Y_MOUTH, MOUTH_WIDTH, MOUTH_HEIGHT, 0, -180);
			g.drawArc(X_MOUTH, Y_MOUTH - 1, MOUTH_WIDTH, MOUTH_HEIGHT, 0, -180);
		}
  }
}