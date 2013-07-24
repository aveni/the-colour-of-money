
public class AvgNeed extends Strategy
{  
  public AvgNeed()
  {
    super.name = "AvgNeed";
  }
  
  public int pickN(Deck d, int target, int total, int turnsRemaining)
  {
    if (total >= target) return 0;
    double avgNeeded = (double)(target-total)/turnsRemaining;

    if (avgNeeded > d.getAvg()) return (int)(.5 + avgNeeded);
    else return (int)(.5 + d.getAvg());
  }
}
