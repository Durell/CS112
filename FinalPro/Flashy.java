/*
CS112:							Final Project
File Name:          Flashy.java
Programmer:         Durell Smith
Date Last Modified: May 22, 2016

Problem Statement:
Create a user friendly flash card application built with a 
GUI for the user to seemlessly interact with.
Priorities:
		1 : Allow user to import CSV files as a start.
		2 : Simplicity is key, even in the complex stages
		3 : Don't overabuse error-handling (try-catch) if there's
					another way to address the issue it's probably better
		4 : The ultimate goal will include a complex algorithm, 
					ideally implemented in a way that is simple for the end
					user to interact with.
		5 : The complexity will have presets for average human learning
					based on studies of spaced repetition memory training concepts.
Algorithm: 
	class name will be Flashy for the base app so probably extend JFrame
	Will use this JFrame throughout with modified panels depending on
	where one is at in the app.

*/

// imports
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.*;
import java.io.*;

public class Flashy extends JFrame implements ActionListener
{
	public final static int WIDTH = 650;
	public final static int HEIGHT = 450;

	private JTextField uname; // username
	private static String userString;
	private FlashcardPanel cards;
	private GreetingPanel greeting;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem open;
	private JMenuItem exit;
	final JFileChooser fc;

	public Flashy()
	{
		super("Flashy");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.white);
		setLayout(new BorderLayout());
		uname = new JTextField("Enter Username");
		cards = new FlashcardPanel();
		greeting = new GreetingPanel();
		add(greeting);

		// menu
		fileMenu = new JMenu("File");
		open = new JMenuItem("Import");
		exit = new JMenuItem("Exit");
		fileMenu.add(open);
		fileMenu.add(exit);
		// This assumes this class extends actionlistener!!!!
		open.addActionListener(this); 
		exit.addActionListener(this);
		fc = new JFileChooser(new File("."));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Comma Seperate Values (.csv)", "csv");
		fc.setFileFilter(filter);
		fc.addActionListener(this);

		JMenuBar bar = new JMenuBar();
		bar.add(fileMenu);
		setJMenuBar(bar);

	}

	public void actionPerformed(ActionEvent e)
	{
		String menuString = e.getActionCommand();
		if(menuString.equals("Import"))
		{
			int returnVal = fc.showOpenDialog(this);
	    if(returnVal == JFileChooser.OPEN_DIALOG) 
  	  {
  	  	File inFile = fc.getSelectedFile();
  	  	Scanner inStream = null;
  	  	try
  	  	{
  	  		inStream = new Scanner(inFile);
  	  	}
				catch (FileNotFoundException f)
				{
					System.out.println(inFile + " not found or could not be opened.");
					System.exit(0);
				}
  	  	String inputValue = JOptionPane.showInputDialog("Enter Deck Title");
    	  //System.out.println("You chose to open this file: " +
    	    //    fc.getSelectedFile().getName());
    		try
    		{
					ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("file.dat"));
				}
				catch (IOException l)
				{
					System.out.println("Error");
				}
    	}
		}
		else if (menuString.equals("Exit"))
		{
			System.exit(0);
		}
	}

  public static void main(String[] args)
  {

  	Flashy gui = new Flashy();
  	gui.setVisible(true);
  }
}