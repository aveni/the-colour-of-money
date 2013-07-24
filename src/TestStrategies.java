
public class TestStrategies
{
  public static double findSuccess(Strategy s, int numRuns, int target)
  {    
    double tot = 0.0;  
    for (int i=0; i<numRuns; i++)
    {
      if (s.runTest(target)) tot++;
    }
    return tot/numRuns;
  }
  
  public static void findRangedSuccess(Strategy s, int numRuns)
  {
    System.out.println(s);
    System.out.print("Target=50: " + findSuccess(s, numRuns, 50));
    System.out.print("\tTarget=60: " + findSuccess(s, numRuns, 60));
    System.out.print("\tTarget=70: " + findSuccess(s, numRuns, 70));
    System.out.print("\tTarget=80: " + findSuccess(s, numRuns, 80));
    System.out.println("\tRandomTarget: " + findSuccess(s, numRuns, -1) + "\n");
  }
  
  public static void main(String[] args)
  {
    findRangedSuccess(new CardValue(), 100000); 
    findRangedSuccess(new AvgNeed(), 100000);
    findRangedSuccess(new WeightedAvgNeed(), 100000);
    findRangedSuccess(new Exp1(), 100000);
  }

}

