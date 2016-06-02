import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JMenuItem;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class MyMenuItem
{
  public class TestMenuItem extends JMenuItem 
  {

  	public TestMenuItem() 
  	{
      this(null);
    }

    public TestMenuItem(String text) 
    {
      super(text);
      super.setContentAreaFilled(false);
    }

  	@Override
    protected void paintComponent(Graphics g) 
    {
        if (getModel().isPressed()) {
            g.setColor(Color.LIGHT_GRAY);
        } else if (getModel().isRollover()) {
            g.setColor(Color.BLACK);
        } else {
            g.setColor(Color.WHITE);
        }
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
  }
}