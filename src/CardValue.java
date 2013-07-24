
public class CardValue extends Strategy
{
  public CardValue()
  {
    super.name = "CardValue";
  }
  
  public int pickN(Deck d, int target, int total, int turnsRemaining)
  {
    if (total >= target) return 0;    
    return (int)(.5 + d.getAvg());
  }
}
