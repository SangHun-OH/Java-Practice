package ATM;

import java.util.Date;

public class Transaction extends ATM {
	

	protected int getBalance() {
		return User_account.getBalance();
	}

	protected void modifyDBAccount() { //DB�� ���� ���� ����
		for (int i = 0; i < AccountDB.account.size(); i++)
			if (AccountDB.account.get(i).getAccountID() == User_account.getAccountID()) {
				int temp = AccountDB.account.get(i).getBalance();
				AccountDB.account.get(i).setBalance(User_account.getBalance() - temp);
				break;
			}
	}

	protected void setLog(String type, int amount) {  //�α� �Է�
		Date now = new Date();
		String log = "���¹�ȣ: " + String.valueOf(User_account.getAccountID()) + "    �ŷ�����: " + type + "    �ݾ�: " + amount
				+ "��" + "    �ܾ�: " + String.valueOf(User_account.getBalance()) + "    �ŷ�����: " + now;
		AccountDB.TransactionLog(log);
	}
}