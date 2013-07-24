public class Combo {
	
	public static int factorial(int n)
	{
		int result=1;
		for(int i=1; i<=n; i++)
		{
			result*=i;
		}
		return result;
	}
	
	public static int binom(int n, int k)
	{
		if(n<k)
		{
			return 0;
		}
		else
		{
			return factorial(n)/(factorial(k)*factorial(n-k));
		}
	}
	
}
