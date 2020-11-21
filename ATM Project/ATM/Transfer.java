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
				JOptionPane.showMessageDialog(null, "본인 계좌에는 이체 할 수 없습니다");
				checker = true;
			} else {
				for (int i = 0; i < AccountDB.account.size(); i++) {
					if (AccountDB.account.get(i).getAccountID() == accountId) {
						User_account.setBalance(-amount);
						modifyDBAccount();
						AccountDB.account.get(i).setBalance(amount);

						setLog("이체", amount);
						checker = true;
					}
				}
			}
			if (!checker)
				JOptionPane.showMessageDialog(null, "상대방의 계좌를 찾을 수 없습니다.");
		} else
			JOptionPane.showMessageDialog(null, "계좌에 금액이 부족합니다.");
	}
}