import javax.swing.JApplet;
import java.awt.Graphics;
import java.awt.Color;

public class Flower extends JApplet
{	
	public void paint(Graphics flower)
	{
		flower.setColor(Color.GREEN);
		flower.drawArc(0, 110, 250, 80, 150, -180);
		flower.drawArc(0, 111, 250, 80, 150, -180);
		flower.drawArc(0, 112, 250, 80, 150, -180);
	    // Set flower color for outer petals
	    flower.setColor(Color.RED);
	    // Fill outer petals with color
	    flower.fillOval(215,86,100,100);
	    flower.fillOval(170,125,100,100);
	    flower.fillOval(185,180,100,100);
	    flower.fillOval(245,195,100,100);
	    flower.fillOval(285,156,100,100);
	    flower.fillOval(274,102,100,100);

	    flower.setColor(Color.CYAN);
	    flower.fillOval(215 + 20 ,86 + 20 ,100 - 30 ,100 - 30);
	    flower.fillOval(170 + 20 ,125 + 20 ,100 - 30 ,100 - 30);
	    flower.fillOval(185 + 20 ,180 + 20 ,100 - 30 ,100 - 30);
	    flower.fillOval(245 + 20 ,195 + 20 ,100 - 30 ,100 - 30);
	    flower.fillOval(285 + 20 ,156 + 20 ,100 - 30 ,100 - 30);
	    flower.fillOval(274 + 20 ,102 + 20 ,100 - 30 ,100 - 30);

	    flower.setColor(Color.ORANGE);
	    flower.fillOval(250 , 160 ,100 - 30 ,100 - 30);

	    flower.setColor(Color.YELLOW);
	    flower.fillOval(250 + 5 , 160 + 5 ,100 - 40 ,100 - 40);
	}
}
