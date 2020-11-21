package bank_account;
import java.util.Scanner;

public class AccountTest {
	public static void main(String[] args) {
			
			Account account1 = new Account(50.00);
			Account account2 = new Account(0.00);
			
			double money = 0.00;
			
			Scanner in = new Scanner(System.in);
			
			account1.getAccount(1);
			account2.getAccount(2);
			
			System.out.print("Enter debit amount for account1: ");
			money = in.nextDouble();
			account1.checkAccount(money, 1);
			account1.getAccount(1);
			account2.getAccount(2);
			
			System.out.print("Enter debit amount for account2: ");
			money = in.nextDouble();
			account2.checkAccount(money, 2);
			account1.getAccount(1);
			account2.getAccount(2);
	}
}
