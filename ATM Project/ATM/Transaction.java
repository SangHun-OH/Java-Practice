package ATM;

import java.util.Date;

public class Transaction extends ATM {
	

	protected int getBalance() {
		return User_account.getBalance();
	}

	protected void modifyDBAccount() { //DB내 계좌 정보 수정
		for (int i = 0; i < AccountDB.account.size(); i++)
			if (AccountDB.account.get(i).getAccountID() == User_account.getAccountID()) {
				int temp = AccountDB.account.get(i).getBalance();
				AccountDB.account.get(i).setBalance(User_account.getBalance() - temp);
				break;
			}
	}

	protected void setLog(String type, int amount) {  //로그 입력
		Date now = new Date();
		String log = "계좌번호: " + String.valueOf(User_account.getAccountID()) + "    거래유형: " + type + "    금액: " + amount
				+ "원" + "    잔액: " + String.valueOf(User_account.getBalance()) + "    거래일자: " + now;
		AccountDB.TransactionLog(log);
	}
}