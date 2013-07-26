import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Benchtable
{

  public static void main(String[] args) throws FileNotFoundException
  {
    Deck deck = new Deck(20);
    deck.removeCard(14); deck.removeCard(15); deck.removeCard(16); deck.removeCard(17);
    deck.removeCard(8); deck.removeCard(9); deck.removeCard(2);
    //Deck is 1 - 13
    
    int need = 57;
    double maxP = 0.0;
    int cardChoice = -1;

    
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
          //Now read previous file to find probability with given need and configuration
          //ArrayList<Integer> tempDeck = deck.getDeck();
          
          int numLine = Combo.findLine(deck); //have to figure out how to find numLine....

          File searchFile = new File(deck.getClass().getResource(".").getPath() + "\\..\\2Last\\2Last_" + temp + ".txt");
          Scanner sc = new Scanner(searchFile);
          for (int k=0; k<numLine+3; k++) sc.nextLine();
          String prob = sc.next();
          prob = prob.substring(1, prob.length() - 1);
          
          //System.out.println("Need: " + temp + "Prob:" + prob);
          
          P += Double.parseDouble(prob);
        }
        
//        System.out.println(deck);
//        System.out.println("Choice: " + N + ", Cardflipped: " + card);
        deck.add(card);
      }

      P/=13.0;
      if (P>maxP)
      {
        maxP = P; cardChoice = N;
      }
    }
    
    System.out.println(maxP); System.out.println(cardChoice);

//    data[counter][0] = maxP;
//    data[counter][1] = cardChoice;
//    counter++;
  }
  
  

}
