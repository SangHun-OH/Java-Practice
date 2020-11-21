
public class PalinMethod {
	
	int count = 1;
	
	public int CountAmount(int nNum)
	{
		if(nNum == -1)
		{
			System.out.println("Bye!");
			
			return -1;
		}
		
		while(nNum/10 != 0)
		{
			nNum /= 10;
			count += 1;
		}
		return count;
	}
	
	public void SplitNum(int counter, int nNum)
	{
		for(int i=0; i<counter/2; i++)
		{
			int A1, A2;
			int a = (int)Math.pow(10.0, (double)(i+1));
			int b = (int)Math.pow(10.0, (double)(counter-1-i));
			
			A1 = (nNum%a)/(int)Math.pow(10.0, (double)i);
			nNum -= A1 * a / 10;
			A2 = nNum/b;
			nNum -= A2 * b;
			
			if(!CheckBothNum(A1, A2))
			{
				System.out.println("Not a palindrome.");
				return;
			}
		}
		System.out.println("Yes, it is a palindrome.");
	}
	
	public boolean CheckBothNum(int A, int B)
	{
		if(A == B)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
}
