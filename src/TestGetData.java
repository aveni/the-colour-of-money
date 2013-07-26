import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;


public class TestGetData
{

  public static void main(String[] args) throws ClassNotFoundException, IOException
  {
    FileInputStream fileIn = new FileInputStream("C:\\Users\\Abhinav\\Documents\\Phillips Andover\\Lower Year\\Comp-500\\" +
        "workspace\\ColourOfMoney\\Data\\3Last");
    ObjectInputStream in = new ObjectInputStream(fileIn);
    double[][] data = (double[][]) in.readObject();
    in.close();
    fileIn.close();
    
    System.out.println("done");
    System.out.println(Arrays.toString(data[4]));
  }

}
