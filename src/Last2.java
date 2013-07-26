import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Last2
{

  public static void main(String[] args) throws IOException
  {
    
    Deck deck = new Deck(20); 
    double[][] data = new double[39][125970];
    
    for (int need = 1; need<=39; need++)
    {
      System.out.println("current need: " + need);
      int counter=0;

      for (int a=1; a<=13; a++)
      {
        for (int b=a+1; b<=14; b++)
        {
          for (int c=b+1; c<=15; c++)
          {
            for (int d=c+1; d<=16; d++)
            {
              for (int e=d+1; e<=17; e++)
              {
                for (int f=e+1; f<=18; f++)
                {
                  for (int g=f+1; g<=19; g++)
                  {
                    for (int h=g+1; h<=20; h++)
                    {          
                      deck = new Deck(20);
                      deck.removeCard(a); deck.removeCard(b); deck.removeCard(c); deck.removeCard(d);
                      deck.removeCard(e); deck.removeCard(f); deck.removeCard(g); deck.removeCard(h);
                                            
                      double maxP = 0.0;
                      
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
                          
                          //System.out.println(deck);
                          //System.out.println("Choice: " + N + ", Cardflipped: " + card + ", P: " + deck.probReach(temp));
                          deck.add(card);
                        }
                        
                        P/=12.0;
                        if (P>maxP)
                        {
                          maxP = P;
                        }
                      }
                      
                      data[need-1][counter] = maxP;
                      counter++;
                    }
                  }
                }
              }
            }
          }
        }
      }
      
      FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Abhinav\\Documents\\Phillips Andover\\Lower Year\\Comp-500\\" +
      		"workspace\\ColourOfMoney\\Data\\2Last");
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(data);
      out.close();
      fileOut.close();
    }
    
  }

}
