package ATM;

import javax.swing.JOptionPane;

public class Deposit extends Transaction {

	protected void deposit(int amount) {
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
				
				if(ft == -1) break;
				if (ft * 50000 > amount) {
					JOptionPane.showMessageDialog(null, "�ʰ��� �ݾ��Դϴ�.");
				} else {
					int tt = (amount - 50000 * ft) / 10000;
					setBalanceATM(tt, ft);

					User_account.setBalance(amount);
					JOptionPane.showMessageDialog(null, "�ܾ�: " + User_account.getBalance() + "��");

					modifyDBAccount();

					setLog("�Ա�", amount);
					break;
				}
			}
		} else {
			int ft = 0;
			int tt = (amount - 50000 * ft) / 10000;
			setBalanceATM(tt, ft);

			User_account.setBalance(amount);
			JOptionPane.showMessageDialog(null, "�ܾ�: " + User_account.getBalance() + "��");
			modifyDBAccount();
			setLog("�Ա�", amount);
		}

	}
}