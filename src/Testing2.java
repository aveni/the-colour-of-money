
public class Testing2
{

  public static void main(String[] args)
  {
    Deck deck = new Deck(20);
    deck.removeCard(13); deck.removeCard(14); deck.removeCard(15); deck.removeCard(16); deck.removeCard(17);
    deck.removeCard(18); deck.removeCard(19); deck.removeCard(20);  
    
    int need = 3;    
    double maxP = 0.0;
    int cardChoice = -1;
    
    for (int i=0; i<12; i++) //finding best choicecard
    {
      double P = 0.0;
      int N = deck.get(i);
      
      for (int j=0; j<12; j++)
      {        
        int temp = need;
        int card = deck.remove(j);                         
        if (card>=N) temp-=N;
        P += deck.probReach(temp);
        
        System.out.println(deck);
        System.out.println("Choice: " + N + ", Cardflipped: " + card + ", P: " + deck.probReach(temp));
        deck.add(card);
      }
      
      P/=12.0;
      if (P>maxP)
      {
        maxP = P; cardChoice = N;
      }
    }
    
    System.out.println("maxP = " + maxP + ", cardChoice = " + cardChoice);
  }

}
