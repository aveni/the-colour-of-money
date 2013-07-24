public class Combo {
	
	public static long factorial(int n)
	{
		long result=1;
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
		else if(k>n/2) return binom(n, n-k);
		else
		{
			long val = 1;
			for (int i=n-k+1; i<=n; i++)
			{
				val*=i;
			}
			return (int)(val/factorial(k));
		}
	}
	
}
