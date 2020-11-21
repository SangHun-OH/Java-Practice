package ATM;

public class Identification {
	private static boolean counter;
	private static Account Identified_Account;
	
	public static boolean checkID(int id, String pw) { // id pw 가 올바른 경우 true 반환
		counter = false;
		for (int i = 0; i < AccountDB.account.size(); i++) {
			if (AccountDB.account.get(i).getAccountID() == id) {
				if (AccountDB.account.get(i).getPw().equals(pw)) {
					Identified_Account = new Account(AccountDB.account.get(i).getAccountType(), AccountDB.account.get(i).getAccountID(),
							AccountDB.account.get(i).getPw(), AccountDB.account.get(i).getBalance());
					counter = true;
				}
			}
		}
		if (counter == true) {
			return true;
		} else
			return false;
	}
	public static Account getUpdatedAccount() { //계좌유형과 잔액을 가져온다
		return Identified_Account;
	}
}
