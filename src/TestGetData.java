import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;


public class TestGetData
{

  public static void main(String[] args) throws ClassNotFoundException, IOException
  {
    FileInputStream fileIn = new FileInputStream("C:\\Users\\Abhinav\\Documents\\Phillips Andover\\Lower Year\\Comp-500\\" +
        "workspace\\ColourOfMoney\\Data\\10Last");
    ObjectInputStream in = new ObjectInputStream(fileIn);
    double[][] data = (double[][]) in.readObject();
    in.close();
    fileIn.close();
    
    System.out.println("done");

    
    double tot=0;
    for (int i=49; i<=79; i++)
    {
      System.out.println("Need=" + (i+1) + ": " + data[i][0]);
      tot+=data[i][0];
    }
    
    System.out.println("Average: " + tot/31);
  }

}
