/*
Chapter No. 1x - Project x
File Name:          SkeletonGUI.java
Programmer:         Durell Smith
Date Last Modified: May x, 2016

Problem Statement:

*/

// imports
import java.awt.event.*;
import javax.swing.*;

public class SkeletonGUI extends JFrame
{

	public final static int WIDTH = 400;
	public final static int HEIGHT = 200;
	public String message;

	JLabel label;
	JPanel messages;

	public SkeletonGUI()
	{
		super("Skeleton");
		setSize(WIDTH, HEIGHT);
		addWindowListener(new SkeletonListener());
		messages = new JPanel();
		label = new JLabel();
		messages.add(label);
		add(messages);
	}

	public class SkeletonListener implements WindowListener
	{
		public void windowOpened(WindowEvent e)
		{
			label.setText("windowOpened() method invoked!");
		}
		public void windowClosing(WindowEvent e)
		{
			label.setText("windowOpened() method invoked!");
		}
		public void windowClosed(WindowEvent e)
		{
			label.setText("windowClosed() method invoked!");
		}
		public void windowIconified(WindowEvent e)
		{
			label.setText("windowIconified() method invoked!");
		}
		public void windowDeiconified(WindowEvent e)
		{
			label.setText("windowDeiconified() method invoked!");
		}
		public void windowActivated(WindowEvent e)
		{
			label.setText("windowActivated() method invoked!");
		}
		public void windowDeactivated(WindowEvent e)
		{
			label.setText("windowDeactivated() method invoked!");
		}
	}

  public static void main(String[] args)
  {
  	SkeletonGUI gui = new SkeletonGUI();
  	gui.setVisible(true);
  }
}