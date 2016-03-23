import javax.swing.JApplet;
import java.awt.Graphics;

public class Play extends JApplet
{
	public void paint(Graphics canvas)
	{
		canvas.drawOval(100, 150, 50, 40);
	}
}