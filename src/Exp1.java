
public class Exp1 extends Strategy
{
  public Exp1()
  {
    super.name = "Exp1";
  }
  
  public int pickN(Deck d, int target, int total, int turnsRemaining)
  {
    if (total >= target) return 0;
    if (turnsRemaining == 1) return target - total;
    if (d.probReach(target-total) > .48) return target-total;

    double avgNeeded = (double)(target-total)/turnsRemaining;   
    double upperLimit = 1.9;
    double weight = 1 + (upperLimit-1)*(turnsRemaining-1)/9;    
    int N = (int)(.5 + weight*avgNeeded); 
    
    return N;
  }
  
  public String toString()
  {
    return "Exp1";
  }
}
