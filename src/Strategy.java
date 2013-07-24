import java.util.ArrayList;

public class Strategy
{
  protected String name;
  
  public Strategy()
  {
    name = "dfltStrategy";
  }
  
  public int pickN(Deck d, int target, int total, int turnsRemaining)
  {
    return 1 + (int)(20*Math.random());
  }
  
  public boolean cardInDeck(Deck d, int i)
  {
    ArrayList<Integer> deck = d.getDeck();
    return deck.contains(i);
  }

  public boolean runTest(int target)
  {
    Deck d = new Deck(20);
    int total = 0;    
    if (target == -1) target = 50 + (int)(31*Math.random());
    //System.out.println("Target: " + target);
    
    for (int i=0; i<10; i++)
    {
      //System.out.println("AvgCardValue: " + d.getAvg());
      int N = pickN(d, target, total, 10-i);     
      while (!cardInDeck(d, N) && d.numGTET(N)>0) N++; //smartGuessing

      int card = d.drawCard();  
      //System.out.println("N chosen: " + N + "\tCard: " + card);
      
      if (card >= N) total += N;
      //System.out.println("Total: " + total + "\t" + "Target: " + target);
    }

    if (total>=target)
    {
      //System.out.println("WIN"); 
      return true;
    }
    else
    {
      //System.out.println("LOSE"); 
      return false;
    }
  }
  
  public String toString()
  {
    return name;
  }
}
