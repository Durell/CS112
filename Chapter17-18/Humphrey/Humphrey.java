/*
Chapter No. 18 - Project 2 (Page 1076)
File Name:          Humphrey.java
Programmer:         Durell Smith
Date Last Modified: May 18, 2016

Problem Statement:

*/

// imports
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;

public class Humphrey extends JFrame
{

	public static int[][] hArray;
	public static int height, width;
	public static	double time;
  public static int max = 0;
  public static int min = 256;

  public static void main(String[] args)
  {
  	Humphrey gui = new Humphrey();
  	int compare = 0;
		for (int i = 0; i < 461; i++)
		{
			for (int j = 0; j < 461; j++)
			{
				compare = hArray[i][j];
			}
		}
			System.out.println("max = " + max + " ; min = " + min);
		time = System.currentTimeMillis() - time;
  	System.out.println("Int test took: " + time);
  	gui.setVisible(true);
  }

	public Humphrey()
	{
		super("Humphrey Image");
		time = System.currentTimeMillis();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		hArray = getFileInput();
		setSize(width, height);
		getContentPane().setBackground(Color.white);
	}

	// read data from humphrey-img: 
	// @post-condition:
	// 1. assign line 1 of file to width and height
	// 2. write lines 2-462 of file to an array to be used in paint()
	public int[][] getFileInput()
	{
		Scanner inputStream = null;
		try
		{
			inputStream = new Scanner(new FileInputStream("humphrey-img.txt"));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("humphrey-img not found or could not be opened.");
			System.exit(0);
		}
		width = inputStream.nextInt();
		height = width;
		inputStream.nextLine();
		int[][] img = new int[461][461];
		for (int i = 0; i < 461; i++)
		{
			for (int j = 0; j < 461; j++)
			{
				img[i][j] = inputStream.nextInt();
				int compare = img[i][j];
				if (compare < min)
					min = compare;
				if (compare > max)
					max = compare;
			}
		}
		inputStream.close();
		return img;
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		Color upgraded = null;

		for (int y = 0; y < 461; y++)
		{
			for (int x = 0; x < 461; x++)
			{
				/*
				int newShade = hArray[y][x];
				newShade = ((255 * (newShade - min))/(max-min));
				upgraded = new Color(newShade, newShade, newShade);
				g.setColor(upgraded);
				g.drawLine(x, y, x, y);
				Original Image:
				*/
				g.setColor(new Color(hArray[y][x], hArray[y][x], hArray[y][x]));
				g.drawLine(x, y, x, y);
				
			}
		}
	}
}