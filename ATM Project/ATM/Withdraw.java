package ATM;

import javax.swing.JOptionPane;

public class Withdraw extends Transaction {
	private boolean valid = false;

	protected void withdraw(int amount) {
		if (amount <= getBalance()) {
			if (amount <= getBalanceATM()) {
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
						if (ft == -1) {
							break;
						}
						if (ft * 50000 > amount) {
							JOptionPane.showMessageDialog(null, "초과된 금액입니다");
						} else {
							int tt = (amount - 50000 * ft) / 10000;
							if (tenThousand >= tt && fiftyThousand >= ft) {
								setBalanceATM(-tt, -ft);
								valid = true;
								break;
							}
							if (tenThousand < tt) {
								JOptionPane.showMessageDialog(null, "현재 만원권의 보유량은 " + tenThousand + "입니다. 인출 불가능");

							}
							if (fiftyThousand < ft) {
								JOptionPane.showMessageDialog(null, "현재 5만원권의 보유량은 " + fiftyThousand + "입니다. 인출 불가능");

							}
						}
					}
				} else {
					while (true) {
						int ft = 0;
						int tt = (amount - 50000 * ft) / 10000;
						if (tenThousand >= tt && fiftyThousand >= ft) {
							setBalanceATM(-tt, -ft);
							valid = true;
							break;
						}
						if (tenThousand < tt) {
							JOptionPane.showMessageDialog(null, "현재 만원권의 보유량은 " + tenThousand + "입니다. 인출 불가능");

						}
						if (fiftyThousand < ft) {
							JOptionPane.showMessageDialog(null, "현재 5만원권의 보유량은 " + fiftyThousand + "입니다. 인출 불가능");
						}
					}
				}
				if (valid) {
					User_account.setBalance(-amount);
					modifyDBAccount();
					JOptionPane.showMessageDialog(null, "잔액 : " + User_account.getBalance());
					setLog("출금", amount);
				}
			} else {
				JOptionPane.showMessageDialog(null, "ATM기에 지폐가 부족합니다.");
			}
		} else {
			JOptionPane.showMessageDialog(null, "계좌에 잔액이 부족합니다.");
		}
	}
}