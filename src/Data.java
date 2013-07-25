import java.io.*;

public class Data {
	private double[][] array;

	public Data(int turn)
	{
		int maxNeed;
		if((41-turn)*turn/2 < 80) {maxNeed = (41-turn)*turn/2;}
		else {maxNeed = 80;}
		array = new double[maxNeed][Combo.binom(20, 10+turn)];
	}
	
	public Data(String path) throws Exception
	{
		FileInputStream fileIn = new FileInputStream(path);
		ObjectInputStream in = new ObjectInputStream(fileIn);
		array = (double[][]) in.readObject();
		in.close();
		fileIn.close();
	}
	
	public void store(String path) throws Exception
	{
		FileOutputStream fileOut = new FileOutputStream(path);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(array);
		out.close();
		fileOut.close();
	}

	public void setValue(int need, Deck deck, double value)
	{
		array[need-1][findLine(deck)] = value;
	}

	public double getValue(int need, Deck deck)
	{
		return array[need-1][findLine(deck)];
	}

	public static int findLine(Deck deck)
	{
		int result=1;
		for(int i=0; i<deck.getSize(); i++)
		{
			result+=Combo.binom(20-deck.get(i), deck.getSize()-i);
		}
		return result;
	}
}
