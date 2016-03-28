/*
*		Author: Paul McElroy
*		Code built on TextDemo.java provided by Dr. Gibbons and Chris Seascholtz
*/

import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;

public class TempConverter
{
	private JPanel panel;
	JComboBox<String> dropdown;
	private JButton button;
	private JTextField text;
	private JLabel label;
	private String conversion;
	private char out;

	public TempConverter()
	{
		panel = new JPanel();
		String[] dropdownContents = {"F to C", "F to K", "C to K", "C to F", "K to F", "K to C"};
		dropdown = new JComboBox<String>(dropdownContents);
		button = new JButton("Convert");
		text = new JTextField(3);//3 cols, not 20 chars
		label = new JLabel("Enter a temperature from F to C");
		conversion = "FtoC";
		out = 'C';


		//Load the listener
		button.addActionListener(buttonListener());
		dropdown.addActionListener(dropdownListener());

		//load the panel
		panel.add(dropdown);
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

				//Checks that the input is a double
				//Below regular expression allows for a number with
				//negative or positive digits, a decimal point, more digits, and
				//scientific notation (also with negative or positive digits)
				String regex = "[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?";
				if(!input.matches(regex))
				{
					label.setText("Enter a number!");
				}
				else if((conversion == "FtoC" || conversion == "FtoK") && (Double.parseDouble(input) < -459.67))
				{
					label.setText("Minimum Farhenheit is -459.67");
				}
				else if((conversion == "CtoF" || conversion == "CtoK") && (Double.parseDouble(input) < -459.67))
				{
					label.setText("Minimum Celsius is -273.15");
				}
				else if((conversion == "KtoC" || conversion == "KtoF") && (Double.parseDouble(input) < -459.67))
				{
					label.setText("Minimum Kelvin is 0");
				}
				else
				{
					double tempIn = Double.parseDouble(input);//convert String to double
					double tempOut = convertTemp(tempIn);
					String newText = "Temp in " + out + ": " + String.format("%.2f",tempOut);//convert double to String and
												       //only display 2 places past decimal
					label.setText(newText);
					System.out.println(newText);
				}
			}
		};

		return listener;
	}

	private ActionListener dropdownListener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = dropdown.getSelectedItem().toString();
				if(input == "F to C")
				{
					label.setText("Enter a temperature from F to C");
					conversion = "FtoC";
					out = 'C';
				}
				else if(input == "F to K")
				{
					label.setText("Enter a temperature from F to K");
					conversion = "FtoK";
					out = 'K';
				}
				else if(input == "C to F")
				{
					label.setText("Enter a temperature from C to F");
					conversion = "CtoF";
					out = 'F';
				}
				else if(input == "C to K")
				{
					label.setText("Enter a temperature from C to K");
					conversion = "CtoK";
					out = 'K';
				}
				else if(input == "K to F")
				{
					label.setText("Enter a temperature from K to F");
					conversion = "KtoF";
					out = 'F';
				}
				else if(input == "K to C")
				{
					label.setText("Enter a temperature from K to C");
					conversion = "KtoC";
					out = 'C';
				}
				else
				{
					label.setText("Enter a temperature from F to C");
					conversion = "FtoC";
					out = 'C';
				}
			}
		};
		return listener;
	}

	private double convertTemp(double input)
	{
		double convertedTemp = 0.0;
		if(conversion == "FtoC")
		{
			convertedTemp = (input - 32)*5/9;
		}
		else if(conversion == "FtoK")
		{
			convertedTemp = (input + 459.67)*5/9;
		}
		else if(conversion == "CtoF")
		{
			convertedTemp = input*9/5 + 32;
		}
		else if(conversion == "CtoK")
		{
			convertedTemp = input + 273.15;
		}
		else if(conversion == "KtoF")
		{
			convertedTemp = input*9/5 - 459.67;
		}
		else if(conversion == "KtoC")
		{
			convertedTemp = input - 273.15;
		}
		else
		{
			convertedTemp = (input - 32)*5/9;
		}
		return convertedTemp;
	}
}
