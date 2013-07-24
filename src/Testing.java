//hello
//hello, human.

import java.io.*;
import java.util.Arrays;


public class Testing
{

  public static void main(String[] args) throws IOException
  {
    
    Deck deck = new Deck(20);      
    
    for (int need = 3; need<=3; need++)
    {
      File file = new File("C:\\Users\\Abhinav\\Documents\\Phillips Andover\\Lower Year\\Comp-500\\" +
      		"workspace\\ColourOfMoney\\2Last\\2Last_" + need + ".txt");
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
      
      double[][] data = new double[125970][14];
      
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
                      
                      //System.out.println(deck);
                      
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
                          
                          //System.out.println(deck);
                          //System.out.println("Choice: " + N + ", Cardflipped: " + card + ", P: " + deck.probReach(temp));
                          deck.add(card);
                        }
                        
                        P/=12.0;
                        if (P>maxP)
                        {
                          maxP = P; cardChoice = N;
                        }
                      }
                      
                      data[counter][0] = maxP;
                      data[counter][1] = cardChoice;
                      data[counter][2] = deck.get(0); data[counter][3] = deck.get(1); data[counter][4] = deck.get(2); data[counter][5] = deck.get(3);
                      data[counter][6] = deck.get(4); data[counter][7] = deck.get(5); data[counter][8] = deck.get(6); data[counter][9] = deck.get(7);
                      data[counter][10] = deck.get(8); data[counter][11] = deck.get(9); data[counter][12] = deck.get(10); data[counter][13] = deck.get(11);

                      counter++;
                    }
                  }
                }
              }
            }
          }
        }
      }
      
      out.println("Need = " + need);
      out.println("-----------------------------------------------------------------"); out.println();
      
      for (double[] a: data)
      {        
        out.println(Arrays.toString(a));
      }
      
      out.close();    
      
//      System.out.println(Arrays.toString(data[0])); //bestcase
//      System.out.println(Arrays.toString(data[data.length - 1])); //worstcase
    }
    
    

  }

}
