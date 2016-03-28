import javax.swing.JFrame;


public class VotingSystemDriver
{
	private static void createAndDisplayGUI()
	{
		JFrame frame = new JFrame("Voting System");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		VotingSystem dApp = new VotingSystem();

		frame.getContentPane().add(dApp.getContent());
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args)
	{
		createAndDisplayGUI();
	}
}
