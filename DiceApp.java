/*
*		Author: Paul McElroy
*		Code built on TextDemo.java provided by Dr. Gibbons and Chris Seascholtz
*/

import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;

public class DiceApp
{
	private JPanel panel;
	private JButton button;
	private JTextField text;
	private JLabel label;

	public DiceApp()
	{
		panel = new JPanel();
		button = new JButton("Roll");
		text = new JTextField(3);//3 cols, not 20 chars
		label = new JLabel("Enter the number of sides");

		//Load the listener
		button.addActionListener(buttonListener());

		//load the panel
		panel.add(text);
		panel.add(button);
		panel.add(label);
	}

	public Component getContent()
	{
		return (panel);
	}

	private ActionListener buttonListener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = text.getText();
        String newText = "";
        String regex = "\\d+"; //check that the input is a number
        if(!input.matches(regex))
        {
          newText = "Enter the number of sides";
        }
        else
        {
          int sides = Integer.parseInt(input);
          DiceObject dice = new DiceObject(sides);
          String roll = Integer.toString(dice.roll()).toString();
  				newText = "The dice rolled: " + roll;
        }

				label.setText(newText);
				System.out.println(newText);
			}
		};

		return listener;
	}
}
