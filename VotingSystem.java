import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.io.*;


public class VotingSystem
{
  private JPanel mainPanel;
	private JPanel panel;
  private JPanel message;
	JComboBox<String> dropdown;
	private JButton button;
	private JTextField firstName;
  private JTextField lastName;
	private JLabel label;
  private File file;
  private String text;

	public VotingSystem()
	{
    mainPanel = new JPanel();
		panel = new JPanel();
    message = new JPanel();
    GridLayout layout = new GridLayout(0, 1);
    GridLayout mainLayout = new GridLayout(2,1);
    panel.setLayout(layout);
    message.setLayout(layout);
    mainPanel.setLayout(mainLayout);
		String[] dropdownContents = {"John Malkovich", "Ian McKellen", "James Dean", "Richard Stallman", "Edward Snowden"};
		dropdown = new JComboBox<String>(dropdownContents);
		button = new JButton("Vote");
		firstName = new JTextField(8);
    lastName = new JTextField(8);
    firstName.setText("First");
    lastName.setText("Last");
    text = "Enter your name and select a candidate              ";
		label = new JLabel(text);


		//Load the listener
		button.addActionListener(buttonListener());

		//load the panel
    mainPanel.add(panel);
    mainPanel.add(message);
		panel.add(firstName);
    panel.add(lastName);
    panel.add(dropdown);
		panel.add(button);
    message.add(label);
	}

	public Component getContent()
	{
		return (mainPanel);
	}

	private ActionListener buttonListener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
          String regex = "[a-zA-Z0-9]+";
          if(firstName.getText().matches(regex) && lastName.getText().matches(regex))
          {
              try {
                String filename = firstName.getText() + "_" + lastName.getText() + "_ballot.txt";
                file = new File(filename);
                boolean fvar = file.createNewFile();
                if (fvar)
                {
                  FileWriter fw = new FileWriter(file,true);
                  BufferedWriter bw = new BufferedWriter(fw);
                  bw.write(dropdown.getSelectedItem().toString());
                  bw.close();
                  text = firstName.getText() + " " + lastName.getText() + " voted for " + dropdown.getSelectedItem().toString();
                }
                else
                {
                  if(file.exists())
                  {
                    BufferedReader br = null;
                    FileReader fr = new FileReader(filename);
                    String candidate = "";
                    try{
                      br = new BufferedReader(fr);
                      candidate = br.readLine();
                    } catch (IOException g)
                    {
                      text = "File Error!";
                    }
                    text = firstName.getText() + " " + lastName.getText() + " already voted for " + candidate + "!";
                  }
                  else
                  {
                    text = "File Error!";
                  }
                }
              } catch (IOException f) {
                text = "File Error!";

                f.printStackTrace();
              }
          }
          else
          {
            text = "First and last name must be alphanumeric!";
          }
          System.out.println(text);
          label.setText(text);
			}
		};

		return listener;
	}
}
