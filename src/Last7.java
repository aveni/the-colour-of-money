import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Last7
{
  public static void main(String[] args) throws IOException, ClassNotFoundException
  {
    FileInputStream fileIn = new FileInputStream("C:\\Users\\Abhinav\\Documents\\Phillips Andover\\Lower Year\\Comp-500\\" +
        "workspace\\ColourOfMoney\\Data\\6Last");
    ObjectInputStream in = new ObjectInputStream(fileIn);
    double[][] last3Data = (double[][]) in.readObject();
    in.close();
    fileIn.close();

    System.out.println("done importing");
    Deck deck = new Deck(20);      
    double[][] data = new double[80][1140];

    for (int need = 1; need<=80; need++)
    {
      System.out.println(need);
      int counter=0;

      for (int a=1; a<=18; a++)
      {
        for (int b=a+1; b<=19; b++)
        {
          for (int c=b+1; c<=20; c++)
          {
                deck = new Deck(20);
                deck.removeCard(a); deck.removeCard(b); deck.removeCard(c);

                double maxP = 0.0;

                for (int i=0; i<17; i++) //finding best choicecard
                {
                  double P = 0.0;
                  int N = deck.get(i);

                  for (int j=0; j<17; j++)
                  {        
                    int temp = need;
                    int card = deck.remove(j); if (card>=N) temp-=N;

                    if (temp<=0) P+=1.0;

                    else if (temp> 80) P +=0.0;

                    else
                    {
                      int numLine = Combo.findLine(deck);
                      P += last3Data[temp-1][numLine];
                    }

                    //                        System.out.println(deck);
                    //                        System.out.println("Choice: " + N + ", Cardflipped: " + card);
                    deck.add(card);
                  }

                  P/=17.0;
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

    FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Abhinav\\Documents\\Phillips Andover\\Lower Year\\Comp-500\\" +
        "workspace\\ColourOfMoney\\Data\\7Last");
    ObjectOutputStream out = new ObjectOutputStream(fileOut);
    out.writeObject(data);
    out.close();
    fileOut.close();
  }

}
