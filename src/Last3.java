import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Last3
{

  public static void main(String[] args) throws IOException, ClassNotFoundException
  {
    FileInputStream fileIn = new FileInputStream("C:\\Users\\Abhinav\\Documents\\Phillips Andover\\Lower Year\\Comp-500\\" +
        "workspace\\ColourOfMoney\\Data\\2Last");
    ObjectInputStream in = new ObjectInputStream(fileIn);
    double[][] last2Data = (double[][]) in.readObject();
    in.close();
    fileIn.close();
    
    System.out.println("done importing");
    Deck deck = new Deck(20);      
    double[][] data = new double[57][77520];
    
    for (int need = 1; need<=57; need++)
    {
      System.out.println(need);
      int counter=0;

      for (int a=1; a<=14; a++)
      {
        for (int b=a+1; b<=15; b++)
        {
          for (int c=b+1; c<=16; c++)
          {
            for (int d=c+1; d<=17; d++)
            {
              for (int e=d+1; e<=18; e++)
              {

                for (int f=e+1; f<=19; f++)
                {
                  for (int g=f+1; g<=20; g++)
                  {
                    deck = new Deck(20);
                    deck.removeCard(a); deck.removeCard(b); deck.removeCard(c); deck.removeCard(d);
                    deck.removeCard(e); deck.removeCard(f); deck.removeCard(g);

                    double maxP = 0.0;
                    
                    for (int i=0; i<13; i++) //finding best choicecard
                    {
                      double P = 0.0;
                      int N = deck.get(i);

                      for (int j=0; j<13; j++)
                      {        
                        int temp = need;
                        int card = deck.remove(j); if (card>=N) temp-=N;
                        
                        if (temp<=0) P+=1.0;
                        
                        else if (temp> 39) P +=0.0;
                        
                        else
                        {
                          int numLine = Combo.findLine(deck);
                          P += last2Data[temp-1][numLine];
                        }
                        
//                        System.out.println(deck);
//                        System.out.println("Choice: " + N + ", Cardflipped: " + card);
                        deck.add(card);
                      }

                      P/=13.0;
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
        "workspace\\ColourOfMoney\\Data\\3Last");
    ObjectOutputStream out = new ObjectOutputStream(fileOut);
    out.writeObject(data);
    out.close();
    fileOut.close();

  }

}
