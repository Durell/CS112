/*
Course: CS 112                 Days & Time: TueThu 1-3

Project Number:		GUI
Programmer(s):  	Russell, Juan M, Ryo, Steven S, Durell
Date Created:       5/12/2016
Program Title:  MySpecialProgram
Program Description:  Do the Stuff
The purpose of this program is to:
Use a GUI to get user data about taxes then calculate said data

Algorithm:
(Detailed, step-by-step, outline of the program - your analysis and design)
1. extend JFrame
2. declare and initialize variables
3. set frame layout to border layout
4. Create panels deductions, marital status, compute, Income, IncomeTax
	a. east, west, center, north, south
5. Add Buttons to panels
	a. 3 radio buttons marital status
	b. 4 jcheck boxes deductions
	c. button for compute
	d. 2 j text fields for incomTax (not editable) and Income (editable)
6. ActionListener for button
	a. store taxable income(double)
	b. check marital status (apply percentage)
	c. check deductions (apply deductions subtract from resulting percentage)
	d. set text for income tax box with decimal formatting
	
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DeathAndTaxes extends JFrame implements ActionListener
{
	private JButton compute;
	private JRadioButton single;
	private JRadioButton married;
	private JRadioButton sHH;
	private JCheckBox self;
	private JCheckBox depC;
	private JCheckBox dag;
	private JCheckBox bgm;
	private JTextField taxable;
	private JTextField iTax;
	private JPanel west;
	private JPanel east;
	private JPanel center;
	private JPanel north;
	private JPanel south;
	
	public DeathAndTaxes()
	{
		super("Death and Taxes!");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		west = new JPanel();
		east = new JPanel();
		center = new JPanel();
		north = new JPanel();
		south = new JPanel();
		
		single = new JRadioButton("Single");
		married = new JRadioButton("Married");
		sHH = new JRadioButton("Single, Head of Household");
		
		west.add(single);
		west.add(married);
		west.add(sHH);
		
		self = new JCheckBox("Self");
		depC = new JCheckBox("Dependent Child");
		dag = new JCheckBox("Three legged dog");
		bgm = new JCheckBox("Blind Grand Mother");
		
		east.add(self);
		east.add(depC);
		east.add(dag);
		east.add(bgm);
		
		taxable = new JTextField("Taxable Income");
		
		iTax = new JTextField("Income Tax");
		iTax.setEditable(false);
		
		north.add(taxable);
		south.add(iTax);
		
		compute = new JButton("Computinate");
		compute. addActionListener(this);
		
		center.add(compute);
		
		add(west, BorderLayout.WEST);
		add(east, BorderLayout.EAST);
		add(center, BorderLayout.CENTER);
		add(north, BorderLayout.NORTH);
		add(south, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		double taxableIncome,
				taxRate = 0;
		String input = taxable.getText();
		int boxesChecked = 0;
		
		try
		{
			taxableIncome = Double.parseDouble(input);
		}
		catch(Exception ex)
		{
			return;
		}
		
		double taxRate;
		
		if(single.isSelected())
		{
			taxRate = .72;
		}
		if(married.isSelected())
		{
			taxRate = .68;
		}
		if(sHH.isSelected())
		{
			taxRate = .78;
		}
		
		taxableIncome *= taxRate;
		
		if(self.isSelected())
		{
			boxesChecked++;
		}
		if(depC.isSelected())
		{
			boxesChecked++;
		}
		if(dag.isSelected())
		{
			boxesChecked++;
		}
		if(bgm.isSelected())
		{
			boxesChecked++;
		}
		
		taxableIncome -= boxesChecked * 2000;
		
	}
}