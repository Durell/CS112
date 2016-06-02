/*
Chapter No. 17 - Handout 4 Project 1
File Name:          Borders.java
Programmer:         Durell Smith
Date Last Modified: May 17, 2016

Problem Statement:
Write a GUI that will let the user sample borders. Include a menu named Borders that offers
three options – beveled border, etched border, and line border – and submenus with the
following options:
• Beveled border options: raised or lowered;
• Etched border options: raised or lowered;
• Line border options: small, medium, or large.
• Each line border submenu should have a submenu with three color options: black,
red, and blue.
Put the borders around a JLabel containing test that describes the border, such as “Raised
Border”, “Lowered Etched Border”, and so forth. Fix the highlight and shadow colors for
the etched border options to whatever colors you like, and make the small line border 5
pixels wide, the medium one 10 pixels wide, and the large one 20 pixels wide.

*/

// imports
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.ButtonGroup;
import javax.swing.border.*;
import javax.swing.BorderFactory;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;


public class Borders extends JFrame implements ActionListener
{

	public static final int WIDTH = 500;
	public static final int HEIGHT = 200;
	public static final int THIN = 5;
	public static final int MEDIUM = 10;
	public static final int BOLD = 20;
	private ButtonGroup bg;

	private JLabel label;
	private BorderFactory border;
	private JPanel bigPanel;
	private JRadioButtonMenuItem raisedBevBlack;
	private JRadioButtonMenuItem loweredBevBlack;
	private JRadioButtonMenuItem raisedEtchBlack;
	private JRadioButtonMenuItem loweredEtchBlack;
	private JRadioButtonMenuItem smallBBlack;
	private JRadioButtonMenuItem medBBlack;
	private JRadioButtonMenuItem largeBBlack;
	private JRadioButtonMenuItem raisedBevRed;
	private JRadioButtonMenuItem loweredBevRed;
	private JRadioButtonMenuItem raisedEtchRed;
	private JRadioButtonMenuItem loweredEtchRed;
	private JRadioButtonMenuItem smallBRed;
	private JRadioButtonMenuItem medBRed;
	private JRadioButtonMenuItem largeBRed;
	private JRadioButtonMenuItem raisedBevBlue;
	private JRadioButtonMenuItem loweredBevBlue;
	private JRadioButtonMenuItem raisedEtchBlue;
	private JRadioButtonMenuItem loweredEtchBlue;
	private JRadioButtonMenuItem smallBBlue;
	private JRadioButtonMenuItem medBBlue;
	private JRadioButtonMenuItem largeBBlue;


	public Borders()
	{
		super("Border Demo");
		setSize(WIDTH, HEIGHT);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bg = new ButtonGroup();

		// Menu
		JMenu borderMenu = new JMenu("Borders");
		JMenu bevBorder = new JMenu("Beveled");
		JMenu etchBorder = new JMenu("Etched");
		JMenu lineOptions = new JMenu("Line Options");
		JMenu raisedB = new JMenu("Raised");
		JMenu loweredB = new JMenu("Lowered");
		JMenu raisedE = new JMenu("Raised");
		JMenu loweredE = new JMenu("Lowered");
		JMenu smB = new JMenu("Small");
		JMenu mB = new JMenu("Medium");
		JMenu lB = new JMenu("Large");

		raisedBevBlack = new JRadioButtonMenuItem("Black");
		loweredBevBlack = new JRadioButtonMenuItem("Black");
		raisedEtchBlack = new JRadioButtonMenuItem("Black");
		loweredEtchBlack = new JRadioButtonMenuItem("Black");
		smallBBlack = new JRadioButtonMenuItem("Black");
		medBBlack = new JRadioButtonMenuItem("Black");
		largeBBlack = new JRadioButtonMenuItem("Black");
		raisedBevRed = new JRadioButtonMenuItem("Red");
		loweredBevRed = new JRadioButtonMenuItem("Red");
		raisedEtchRed = new JRadioButtonMenuItem("Red");
		loweredEtchRed = new JRadioButtonMenuItem("Red");
		smallBRed = new JRadioButtonMenuItem("Red");
		medBRed = new JRadioButtonMenuItem("Red");
		largeBRed = new JRadioButtonMenuItem("Red");
		raisedBevBlue = new JRadioButtonMenuItem("Blue");
		loweredBevBlue = new JRadioButtonMenuItem("Blue");
		raisedEtchBlue = new JRadioButtonMenuItem("Blue");
		loweredEtchBlue = new JRadioButtonMenuItem("Blue");
		smallBBlue = new JRadioButtonMenuItem("Blue");
		medBBlue = new JRadioButtonMenuItem("Blue");
		largeBBlue = new JRadioButtonMenuItem("Blue");
		bg.add(raisedBevBlack);
		bg.add(loweredBevBlack);
		bg.add(raisedEtchBlack);
		bg.add(loweredEtchBlack);
		bg.add(smallBBlack);
		bg.add(medBBlack);
		bg.add(largeBBlack);
		bg.add(raisedBevRed);
		bg.add(loweredBevRed);
		bg.add(raisedEtchRed);
		bg.add(loweredEtchRed);
		bg.add(smallBRed);
		bg.add(medBRed);
		bg.add(largeBRed);
		bg.add(raisedBevBlue);
		bg.add(loweredBevBlue);
		bg.add(raisedEtchBlue);
		bg.add(loweredEtchBlue);
		bg.add(smallBBlue);
		bg.add(medBBlue);
		bg.add(largeBBlue);

		raisedBevBlack.setActionCommand("Black Raised Bevel");
		loweredBevBlack.setActionCommand("Black Lowered Bevel");
		raisedEtchBlack.setActionCommand("Black Raised Etched");
		loweredEtchBlack.setActionCommand("Black Lowered Etched");
		smallBBlack.setActionCommand("Black Small Line");
		medBBlack.setActionCommand("Black Medium Line");
		largeBBlack.setActionCommand("Black Bold Line");
		raisedBevRed.setActionCommand("Red Raised Bevel");
		loweredBevRed.setActionCommand("Red Lowered Bevel");
		raisedEtchRed.setActionCommand("Red Raised Etched");
		loweredEtchRed.setActionCommand("Red Lowered Etched");
		smallBRed.setActionCommand("Red Small Line");
		medBRed.setActionCommand("Red Medium Line");
		largeBRed.setActionCommand("Red Bold Line");
		raisedBevBlue.setActionCommand("Blue Raised Bevel");
		loweredBevBlue.setActionCommand("Blue Lowered Bevel");
		raisedEtchBlue.setActionCommand("Blue Lowered Etched");
		loweredEtchBlue.setActionCommand("Blue Lowered Etched");
		smallBBlue.setActionCommand("Blue Small Line");
		medBBlue.setActionCommand("Blue Medium Line");
		largeBBlue.setActionCommand("Blue Bold Line");

		raisedBevBlack.addActionListener(this);
		loweredBevBlack.addActionListener(this);
		raisedEtchBlack.addActionListener(this);
		loweredEtchBlack.addActionListener(this);
		smallBBlack.addActionListener(this);
		medBBlack.addActionListener(this);
		largeBBlack.addActionListener(this);
		raisedBevRed.addActionListener(this);
		loweredBevRed.addActionListener(this);
		raisedEtchRed.addActionListener(this);
		loweredEtchRed.addActionListener(this);
		smallBRed.addActionListener(this);
		medBRed.addActionListener(this);
		largeBRed.addActionListener(this);
		raisedBevBlue.addActionListener(this);
		loweredBevBlue.addActionListener(this);
		raisedEtchBlue.addActionListener(this);
		loweredEtchBlue.addActionListener(this);
		smallBBlue.addActionListener(this);
		medBBlue.addActionListener(this);
		largeBBlue.addActionListener(this);

		borderMenu.add(bevBorder);
		borderMenu.add(etchBorder);
		borderMenu.add(lineOptions);

		bevBorder.add(raisedB);
		bevBorder.add(loweredB);
		raisedB.add(raisedBevBlack);
		loweredB.add(loweredBevBlack);
		raisedB.add(raisedBevBlue);
		loweredB.add(loweredBevBlue);
		raisedB.add(raisedBevRed);
		loweredB.add(loweredBevRed);

		etchBorder.add(raisedE);
		etchBorder.add(loweredE);
		raisedE.add(raisedEtchBlack);
		loweredE.add(loweredEtchBlack);
		raisedE.add(raisedEtchBlue);
		loweredE.add(loweredEtchBlue);
		raisedE.add(raisedEtchRed);
		loweredE.add(loweredEtchRed);

		lineOptions.add(smB);
		lineOptions.add(mB);
		lineOptions.add(lB);
		smB.add(smallBBlack);
		mB.add(medBBlack);
		lB.add(largeBBlack);
		smB.add(smallBBlue);
		mB.add(medBBlue);
		lB.add(largeBBlue);
		smB.add(smallBRed);
		mB.add(medBRed);
		lB.add(largeBRed);

		// UI
		label = new JLabel("Default Border Selection");
		JPanel labelPanel = new JPanel();
		JPanel northPanel = new JPanel();
		bigPanel = new JPanel(new BorderLayout(0, 40));
		bigPanel.setBorder(BorderFactory.createTitledBorder("sick"));
		labelPanel.add(label);
		add(bigPanel);
		bigPanel.add(northPanel, BorderLayout.NORTH);
		bigPanel.add(labelPanel, BorderLayout.CENTER);
		// create and populate the MenuBar
		JMenuBar bar = new JMenuBar();
		bar.add(borderMenu);
		setJMenuBar(bar);
  	setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		String menuString = e.getActionCommand();
		if (menuString.equals("Black Raised Bevel"))
		{
			bigPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.BLACK, Color.BLACK, Color.DARK_GRAY, Color.GRAY));
			label.setText("Black Raised Bevel");
		}
		else if (menuString.equals("Black Lowered Bevel"))
		{
			bigPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.DARK_GRAY, Color.GRAY));
			label.setText("Black Lowered Bevel");
		}
		else if (menuString.equals("Red Raised Bevel"))
		{
			bigPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.RED, Color.RED, Color.DARK_GRAY, Color.GRAY));
			label.setText("Red Raised Bevel");
		}
		else if (menuString.equals("Red Lowered Bevel"))
		{
			bigPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.RED, Color.RED, Color.DARK_GRAY, Color.GRAY));
			label.setText("Red Lowered Bevel");
		}
		else if (menuString.equals("Blue Raised Bevel"))
		{
			bigPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.BLUE, Color.BLUE, Color.DARK_GRAY, Color.GRAY));
			label.setText("Blue Raised Bevel");
		}
		else if (menuString.equals("Blue Lowered Bevel"))
		{
			bigPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED , Color.BLUE, Color.BLUE, Color.DARK_GRAY, Color.GRAY));
			label.setText("Blue Lowered Bevel");
		}
		else if (menuString.equals("Black Raised Etched"))
		{
			bigPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.BLACK, Color.GRAY));
			label.setText("Black Raised Etched");
		}
		else if (menuString.equals("Black Lowered Etched"))
		{
			bigPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.BLACK, Color.GRAY));
			label.setText("Black Lowered Etched");
		}
		else if (menuString.equals("Blue Raised Etched"))
		{
			bigPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.BLUE, Color.GRAY));
			label.setText("Blue Raised Etched");
		}
		else if (menuString.equals("Blue Lowered Etched"))
		{
			bigPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.BLUE, Color.GRAY));
			label.setText("Blue Lowered Etched");
		}
		else if (menuString.equals("Red Raised Etched"))
		{
			bigPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.RED, Color.GRAY));
			label.setText("Red Raised Etched");
		}
		else if (menuString.equals("Red Lowered Etched"))
		{
			bigPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.RED, Color.GRAY));
			label.setText("Red Lowered Etched");
		}
		else if (menuString.equals("Black Small Line"))
		{	
			bigPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, THIN));
			label.setText("Thin Black Lined Border");
		}
		else if (menuString.equals("Red Small Line"))
		{	
			bigPanel.setBorder(BorderFactory.createLineBorder(Color.RED, THIN));
			label.setText("Thin Red Lined Border");
		}
		else if (menuString.equals("Blue Small Line"))
		{	
			bigPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, THIN));
			label.setText("Thin Blue Lined Border");
		}
		else if (menuString.equals("Black Medium Line"))
		{	
			bigPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, THIN));
			label.setText("Medium Black Lined Border");
		}
		else if (menuString.equals("Red Medium Line"))
		{	
			bigPanel.setBorder(BorderFactory.createLineBorder(Color.RED, MEDIUM));
			label.setText("Medium Red Lined Border");
		}
		else if (menuString.equals("Blue Medium Line"))
		{	
			bigPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, MEDIUM));
			label.setText("Medium Blue Lined Border");
		}
		else if (menuString.equals("Black Bold Line"))
		{	
			bigPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, THIN));
			label.setText("Bold Black Lined Border");
		}
		else if (menuString.equals("Red Bold Line"))
		{	
			bigPanel.setBorder(BorderFactory.createLineBorder(Color.RED, BOLD));
			label.setText("Bold Red Lined Border");
		}
		else if (menuString.equals("Blue Bold Line"))
		{	
			bigPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, BOLD));
			label.setText("Bold Blue Lined Border");
		}
	}

  public static void main(String[] args)
  {
  	Borders gui = new Borders();
  }
}