/**
 * File Name: ColoredFace.java
 *
 * Homework Problem: #6-7
 *
 * @author 
 * @version 1.00 16/02/02
 */
 
import java.awt.*;
import java.applet.*;
import javax.swing.JApplet;


public class Target extends JApplet 
{
	// Starting circle
	public static final int OG_DIAMETER = 250;
	public static final int x = 120;
	public static final int y = 80;

	public void paint(Graphics canvas) 
	{
		for (int i = 0; i < 5; i++)
		{
			int offset = i * 25;
			int shrink = i * 50;
			if (i % 2 != 0)
				canvas.setColor(Color.GREEN);
			else
				canvas.setColor(Color.BLUE);
			canvas.fillOval(x + offset, y + offset, OG_DIAMETER - shrink, OG_DIAMETER - shrink);
			canvas.setColor(Color.BLACK);
			canvas.drawOval(x + offset, y + offset, OG_DIAMETER - shrink, OG_DIAMETER - shrink);
		} // end for loop
	} // end paint()
} // end class
