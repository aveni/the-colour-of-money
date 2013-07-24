import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Last3
{

  public static void main(String[] args) throws IOException
  {

    Deck deck = new Deck(20);      
    ArrayList<ArrayList<Integer>> decks = new ArrayList<ArrayList<Integer>>(77520);

    for (int need = 1; need<=1; need++)
    {
      File file = new File("C:\\Users\\Abhinav\\Documents\\Phillips Andover\\Lower Year\\Comp-500\\" +
          "workspace\\ColourOfMoney\\3Last\\3Last_" + need + ".txt");
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));

      double[][] data = new double[77520][2];

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

                    if (need == 1) decks.add(deck.getDeck()); //add to decks array
                    System.out.println(deck);
/////////////////////////////////////////////////////////////////////////////////////////
                    
                    
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

    File file = new File("C:\\Users\\Abhinav\\Documents\\Phillips Andover\\Lower Year\\Comp-500\\" +
        "workspace\\ColourOfMoney\\3Last\\3Last_AllDecks.txt");
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
    
    for (ArrayList<Integer> a: decks) out.println(a);    
    out.close(); 


  }

}
