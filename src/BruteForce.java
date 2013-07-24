
public class BruteForce extends Strategy
{
  
  public int pickLast(int target, int total){return target-total;}
  
  public int pickN(Deck d, int target, int total, int turnsRemaining)
  {
    if (turnsRemaining == 1) return pickLast(target, total);
    
    return 0;
  }
}
