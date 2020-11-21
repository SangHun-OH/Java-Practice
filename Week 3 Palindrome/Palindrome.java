import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		
		PalinMethod pMethod = new PalinMethod();
		Scanner input = new Scanner(System.in);
		int nNum = 0;
		int counter = 0;
		
		do
		{
			nNum = input.nextInt();
			counter = pMethod.CountAmount(nNum);
			if(counter == -1){break;			}
			System.out.println(nNum + ", " + counter);
			pMethod.SplitNum(counter, nNum);
		}while(counter != -1);
	}
}