/*
*		Author: Paul McElroy
*		Code built on TextDemoDriver.java provided by Dr. Gibbons and Chris Seascholtz
*/

import javax.swing.JFrame;


public class TempConverterDriver
{
	private static void createAndDisplayGUI()
	{
		JFrame frame = new JFrame("Temperature Converter");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TempConverter tempConv = new TempConverter();

		frame.getContentPane().add(tempConv.getContent());
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args)
	{
		createAndDisplayGUI();
	}
}
