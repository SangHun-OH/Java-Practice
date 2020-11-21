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
						String select = JOptionPane.showInputDialog(null, "�������� ����� �Է��ϼ���.");
						if (select == null)
							break;
						if (select.isEmpty()) {
							JOptionPane.showMessageDialog(null, "�������� ����� �Է����� �ʾҽ��ϴ�.");
							continue;
						}
						else
							ft = Integer.parseInt(select);
						if (ft == -1) {
							break;
						}
						if (ft * 50000 > amount) {
							JOptionPane.showMessageDialog(null, "�ʰ��� �ݾ��Դϴ�");
						} else {
							int tt = (amount - 50000 * ft) / 10000;
							if (tenThousand >= tt && fiftyThousand >= ft) {
								setBalanceATM(-tt, -ft);
								valid = true;
								break;
							}
							if (tenThousand < tt) {
								JOptionPane.showMessageDialog(null, "���� �������� �������� " + tenThousand + "�Դϴ�. ���� �Ұ���");

							}
							if (fiftyThousand < ft) {
								JOptionPane.showMessageDialog(null, "���� 5�������� �������� " + fiftyThousand + "�Դϴ�. ���� �Ұ���");

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
							JOptionPane.showMessageDialog(null, "���� �������� �������� " + tenThousand + "�Դϴ�. ���� �Ұ���");

						}
						if (fiftyThousand < ft) {
							JOptionPane.showMessageDialog(null, "���� 5�������� �������� " + fiftyThousand + "�Դϴ�. ���� �Ұ���");
						}
					}
				}
				if (valid) {
					User_account.setBalance(-amount);
					modifyDBAccount();
					JOptionPane.showMessageDialog(null, "�ܾ� : " + User_account.getBalance());
					setLog("���", amount);
				}
			} else {
				JOptionPane.showMessageDialog(null, "ATM�⿡ ���� �����մϴ�.");
			}
		} else {
			JOptionPane.showMessageDialog(null, "���¿� �ܾ��� �����մϴ�.");
		}
	}
}