package ATM;

import javax.swing.JOptionPane;

public class Transfer extends Transaction {
	private boolean checker = false;

	public boolean getchecker() {
		return checker;
	}

	protected void transfer(int amount, int accountId) {
		if (amount <= User_account.getBalance()) {
			if (accountId == User_account.getAccountID()) {
				JOptionPane.showMessageDialog(null, "���� ���¿��� ��ü �� �� �����ϴ�");
				checker = true;
			} else {
				for (int i = 0; i < AccountDB.account.size(); i++) {
					if (AccountDB.account.get(i).getAccountID() == accountId) {
						User_account.setBalance(-amount);
						modifyDBAccount();
						AccountDB.account.get(i).setBalance(amount);

						setLog("��ü", amount);
						checker = true;
					}
				}
			}
			if (!checker)
				JOptionPane.showMessageDialog(null, "������ ���¸� ã�� �� �����ϴ�.");
		} else
			JOptionPane.showMessageDialog(null, "���¿� �ݾ��� �����մϴ�.");
	}
}