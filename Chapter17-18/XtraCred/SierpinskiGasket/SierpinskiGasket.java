/*
Chapter No. 18 - Project 1 (Page 1075)
File Name:          SierpinskiGasket.java
Programmer:         Durell Smith
Date Last Modified: May 18, 2016

Problem Statement:

*/

// imports
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class SierpinskiGasket extends JFrame
{

	public static final int WIDTH = 525;
	public static final int HEIGHT = 480;
	public Point x = new Point(260, 30);
	public Point y = new Point(10, 463);
	// public Point y = new Point(270, 291);
	public Point z = new Point(510, 463);

  public static void main(String[] args)
  {
  	SierpinskiGasket gui = new SierpinskiGasket();
  	gui.setVisible(true);
  }

	public SierpinskiGasket()
	{
		super("Sierpinski Gasket Fractal");
		setSize(WIDTH, HEIGHT);
		getContentPane().setBackground(Color.WHITE);
	}

	public Point getMidpoint(Point p1, Point p2)
	{
		int newX = ((p1.getX() + p2.getX()) / 2);
		int newY = ((p1.getY() + p2.getY()) / 2);
		return (new Point(newX, newY));
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.BLACK);
		/*
		g.drawLine(x.getX(),x.getY(),y.getX(),y.getY());
		g.drawLine(y.getX(),y.getY(),z.getX(),z.getY());
		g.drawLine(x.getX(),x.getY(),z.getX(),z.getY());
			*/
		Random ran = new Random();
		Point current = x;
		Point target = null;
		int next = (ran.nextInt(3) + 1);
		for (int i = 0; i < 10000000; i++)
		{
			if (next == 1)
				target = x;
			else if (next == 2)
				target = y;
			else
				target = z;
			current = getMidpoint(current, target);
			g.drawLine(current.getX(), current.getY(), current.getX(), current.getY());
			next = (ran.nextInt(3) + 1);
		}
	}
}