package ATM;

import javax.swing.JOptionPane;

public class Deposit extends Transaction {

	protected void deposit(int amount) {
		if (amount >= 50000) {
			while (true) {
				int ft = 0;
				String select = JOptionPane.showInputDialog(null, "오만원권 장수를 입력하세요.");
				if (select == null)
					break;
				if (select.isEmpty()) {
					JOptionPane.showMessageDialog(null, "오만원권 장수를 입력하지 않았습니다.");
					continue;
				}
				else
					ft = Integer.parseInt(select);
				
				if(ft == -1) break;
				if (ft * 50000 > amount) {
					JOptionPane.showMessageDialog(null, "초과된 금액입니다.");
				} else {
					int tt = (amount - 50000 * ft) / 10000;
					setBalanceATM(tt, ft);

					User_account.setBalance(amount);
					JOptionPane.showMessageDialog(null, "잔액: " + User_account.getBalance() + "원");

					modifyDBAccount();

					setLog("입금", amount);
					break;
				}
			}
		} else {
			int ft = 0;
			int tt = (amount - 50000 * ft) / 10000;
			setBalanceATM(tt, ft);

			User_account.setBalance(amount);
			JOptionPane.showMessageDialog(null, "잔액: " + User_account.getBalance() + "원");
			modifyDBAccount();
			setLog("입금", amount);
		}

	}
}