import java.util.ArrayList;
import java.util.Collections;


public class Deck
{
  private ArrayList<Integer> deck;
  
  public Deck(int n)
  {
    deck = new ArrayList<Integer>(n);
    for (int i=1; i<=n; i++)
    {
      deck.add(i);
    }
  }

  public void removeCard(int n)
  {
    deck.remove(new Integer(n));
  }
  
  public int remove(int n)
  {
    return deck.remove(n);
  }
  
  public void add(int n)
  {
    deck.add(new Integer(n));
    Collections.sort(deck);
  }
  
  public int get(int n)
  {
    return deck.get(n);
  }
  
  public int numGTET(double n)
  {
    int tot=0;
    for (Integer i: deck) if(i>=n) tot++;
    return tot;
  }
  
  public double probReach(double n)
  {
    return ((double)numGTET(n))/deck.size();
  }
  
  public ArrayList<Integer> getDeck()
  {
    return deck;
  }
  
  public int getSize()
  {
    return deck.size();
  }
  
  public int drawCard()
  {
    return deck.remove((int) (Math.random()*deck.size()));
  }
  
  public int getSum()
  {
    int sum = 0;
    for (Integer i: deck)
    {
      sum += (int)i;
    }
    
    return sum;
  }
  
  public double getAvg()
  {
    return (double)getSum()/deck.size();
  }
  
  public void resetDeck(int n)
  {
    deck = new ArrayList<Integer>(n);
    for (int i=1; i<=n; i++)
    {
      deck.add(i);
    }
  }
  
  public String toString()
  {
    return deck.toString();
  } 
}
