import java.util.Random;

public class DiceObject
{
	private int mSides;
  private Random randomGenerator;

	public DiceObject(int sides)
	{
    mSides = sides;
    randomGenerator = new Random(System.currentTimeMillis());
	}

	public int getSides()
	{
		return(mSides);
	}

  public int roll()
  {
    return randomGenerator.nextInt(mSides) + 1;
  }
}


// DiceObject D6 = new DiceObject(6);
// String myRoll = Integer.toString(D6.roll()).toString();
// JLabel label = new JLabel(myRoll, JLabel.RIGHT);
