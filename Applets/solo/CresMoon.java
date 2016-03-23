import javax.swing.JApplet;
import java.awt.Graphics;
import java.awt.Color;

public class CresMoon extends JApplet
{
	public void paint(Graphics canvas)
	{
		canvas.setColor(Color.BLUE);
		canvas.fillRect(0, 0, 500, 400);
		canvas.setColor(Color.GRAY);
		canvas.fillArc(150, 50, 300, 300, 90, 190);
		canvas.setColor(Color.BLACK);
		canvas.drawArc(150, 50, 300, 300, 90, 190);
		canvas.setColor(Color.BLUE);
		canvas.fillArc(250, 52, 120, 300, 90, 360);
		canvas.setColor(Color.BLACK);
		canvas.drawArc(250, 52, 120, 300, 99, 160);
	}
}