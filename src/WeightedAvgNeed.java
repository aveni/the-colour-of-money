
public class WeightedAvgNeed extends Strategy
{
  public WeightedAvgNeed()
  {
    super.name = "WeightedAvgNeed";
  }
  
  public int pickN(Deck d, int target, int total, int turnsRemaining)
  {
    if (total >= target) return 0;
    double avgNeeded = (double)(target-total)/turnsRemaining;
    
    double upperLimit = 1.9;
    double weight = 1 + (upperLimit-1)*(turnsRemaining-1)/9;
    
    int N = (int)(.5 + weight*avgNeeded);    
    return N;
  }

}
