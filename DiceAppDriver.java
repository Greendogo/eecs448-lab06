import javax.swing.JFrame;


public class DiceAppDriver
{
	private static void createAndDisplayGUI()
	{
		JFrame frame = new JFrame("Dice Roller");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DiceApp dApp = new DiceApp();

		frame.getContentPane().add(dApp.getContent());
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args)
	{
		createAndDisplayGUI();
	}
}
