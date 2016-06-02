/*
Chapter No. 18 - Project 6 (Page 1077)
File Name:          FontGUI.java
Programmer:         Durell Smith
Date Last Modified: May 22, 2016

Problem Statement:

*/

// imports
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class FontGUI extends JFrame implements ActionListener
{

	public static final int WIDTH = 400;
	public static final int HEIGHT = 200;

	private JMenuBar menuBar;
	private JMenu file;
	private JMenuItem exit;
	private JMenu format;
	private JMenu font;
	private JMenuItem serif;
	private JMenuItem mono;
	private JMenuItem sans;

	private JMenu style;
	private JRadioButtonMenuItem bold;
	private JRadioButtonMenuItem italic;
	private JMenu size;
	private JMenuItem s9;
	private JMenuItem s10;
	private JMenuItem s12;
	private JMenuItem s14;
	private JMenuItem s16;
	private JMenuItem s24;
	private JMenuItem s32;
	private JTextField input;
	private JButton display;

	private JPanel mainPanel;

  public static void main(String[] args)
  {
  	FontGUI gui = new FontGUI();
  	gui.setVisible(true);
  }

  public FontGUI()
  {
  	super("Fonts Demo");
  	setSize(WIDTH, HEIGHT);
  	getContentPane().setBackground(Color.white);
  	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  	// Setup Menus
  	file = new JMenu("File");
  	exit = new JMenuItem("Exit");
  	exit.addActionListener(this);
  	file.add(exit);
  	format = new JMenu("Format");
  	font = new JMenu("Font");
  	serif = new JMenuItem("Serif");
  	sans = new JMenuItem("Sans-Serif");
  	mono = new JMenuItem("Monospaced");
  	serif.addActionListener(this);
  	font.add(serif);
  	font.add(sans);
  	font.add(mono);
  	format.add(font);
  	style = new JMenu("Style");
  	bold = new JRadioButtonMenuItem("Bold");
  	italic = new JRadioButtonMenuItem("Italic");
  	style.add(bold);
  	style.add(italic);
  	format.add(style);
  	size = new JMenu("Size");
  	s9 = new JMenuItem("9");
  	s10 = new JMenuItem("10");
  	s12 = new JMenuItem("12");
  	s14 = new JMenuItem("14");
  	s16 = new JMenuItem("16");
  	s24 = new JMenuItem("24");
  	s32 = new JMenuItem("32");
  	size.add(s9);
  	size.add(s10);
  	size.add(s12);
  	size.add(s14);
  	size.add(s16);
  	size.add(s24);
  	size.add(s32);
  	format.add(size);
  	menuBar = new JMenuBar();
  	menuBar.add(file);
  	menuBar.add(format);
  	setJMenuBar(menuBar);

  	// Main Display Setup
  	mainPanel = new JPanel();
  	input = new JTextField(12);
  	display = new JButton("Display");
  	mainPanel.add(input);
  	mainPanel.add(display);
  	add(mainPanel);
  }

  public void actionPerformed(ActionEvent e)
  {
  	String action = e.getActionCommand();
  	if (action.equals("Exit"))
  		System.exit(0);
  	else if (action.equals("Serif"))
  	else if (action.equals("Sans-Serif"))
  	else if (action.equals("Monospaced"))
  	else if (action.equals("Bold"))
  	else if (action.equals("Italic"))
  	else if (action.equals("9"))
  	else if (action.equals("10"))
  	else if (action.equals("12"))
  	else if (action.equals("14"))
  	else if (action.equals("16"))
  	else if (action.equals("24"))
  	else if (action.equals("32"))
  		;
  }

/*
  public void paint(Graphics g)
  {
  	super.paint(g);

  }
  */
}