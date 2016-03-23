import javax.swing.JApplet;
import java.awt.Graphics;
import java.awt.Color;

public class CircleBox extends JApplet
{
	public void paint(Graphics canvas)
	{
		canvas.setColor(Color.YELLOW);
		canvas.fillRect(100, 50, 300, 300);
		canvas.setColor(Color.RED);
		canvas.fillOval(100, 50, 300, 300);
		canvas.setColor(Color.BLACK);
		canvas.drawRect(100, 50, 300, 300);
		canvas.drawOval(100, 50, 300, 300);
	}
}