/*
Chapter No. 17 - Project 1 (Page 1013)
File Name:          Borders.java
Programmer:         Durell Smith
Date Last Modified: May 17, 2016

*/

// import
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.util.Scanner;

public class PigLatin extends JFrame implements ActionListener
{
	public static final int WIDTH = 500;
	public static final int HEIGHT = 200;

	private JTextArea sourceText;
	private JTextArea translatedText;

	public PigLatin()
	{
		super("Pig Latin Translator");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout( new FlowLayout( ));
		sourceText = new JTextArea("Enter Text", 3, 15);
		add(sourceText);
		JButton translateButton = new JButton("Translate");
		translateButton.addActionListener(this);
		add(translateButton);
		translatedText = new JTextArea("Translated", 3, 15);
		translatedText.setEditable(false);
		add(translatedText);
	}

	public void actionPerformed(ActionEvent e)
	{
		String input = sourceText.getText();
		Scanner parser = new Scanner(input);
		String vowels = "aeiou";
		String output = "";

		while(parser.hasNext())
		{
			String pigWord = parser.next();
			char c = pigWord.toLowerCase().charAt(0);
			if (vowels.indexOf(c) != -1)
				pigWord = pigWord + "lay";
			else
				pigWord = pigWord.substring(1) + c + "ay";
			output = output + " " + pigWord;
		}
		translatedText.setText(output);
	}

	public static void main(String[] args)
	{
		PigLatin gui = new PigLatin();
		gui.setVisible( true);
	}
}
