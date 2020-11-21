package bank_account;

public class Account {

	private double result;

	public Account(double new_account){
		result = new_account;
	}

	public void getAccount(int num){
		System.out.printf("account%d balance: $%.2f\n", num, result);
	}

	public boolean checkAccount(double money, int num){
		System.out.printf("subtracing %.2f from account%d balance\n", money, num);

		if(money <= result){
			result = result - money;
			return true;
		}

		else{
			System.out.println("Debit amount exceeded account balance");
			return false;
		}
	}
}
