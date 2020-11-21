package ATM;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GUI extends ATM implements ActionListener {
	private int frame;
	private JFrame FR = new JFrame();
	private JPanel mainPN;
	private JLabel mainLB;
	private JPanel CheckID;
	private JPanel GetBalance;
	private JPanel Trans;
	private JPanel both;
	private JPanel menu;

	private JLabel checkLB;
	private JLabel checkLB2;
	private JLabel AdminLB;
	private JLabel PlusATM;
	private JLabel UserID = new JLabel("���¹�ȣ �Է�");
	private JLabel AdminID = new JLabel("������ID �Է�: ");
	private JLabel UserPW = new JLabel("��й�ȣ �Է�");
	private JTextField getID;
	private JTextField getPW;

	private JLabel transitLB;
	private JLabel AmountLabel = new JLabel("��ü�� �ݾ� �Է� ");
	private JLabel AccountLabel = new JLabel("��ü�� ���� ��ȣ �Է� ");

	private JTextField amountNo;
	private JTextField accountNo;
	private JLabel Bal;

	private JButton select = new JButton("Ȯ��");
	private JButton trans_select = new JButton("Ȯ��");
	private JButton Ad_select = new JButton("�α���");

	private JButton exit = new JButton("���� ȭ��");
	private JButton exit0 = new JButton("���� ȭ��");
	private JButton exit3 = new JButton("���� ȭ��");
	private JButton exit4 = new JButton("���� ȭ��");

	private JPanel depositPN;
	private JLabel depositLB;
	private JTextField depositValue;
	private JButton depositBT;
	private JButton mainBackBT;

	private JPanel withdrawPN;
	private JLabel withdrawLB;
	private JTextField withdrawValue;
	private JButton withdrawBT;
	private JButton mainBackBT2;

	private JButton LogB;
	private JButton ATMcheckB;
	private JButton ATMInB;

	private JPanel getATMbal;
	private JButton Input;
	private JButton Adexit;
	
	private JLabel UserAccount;
	private JLabel UserBal ;
	private JLabel UserValue; 

	private JLabel inputT;
	private JTextField tenT;

	private JLabel inputF;
	private JTextField fiftyT;

	private String[] menuText = { "������ȸ", "�����Ա�", "�ŷ�����", "������ü", "�������", "�����ڱ���" };

	private final int ButtonNum = menuText.length;
	private JButton[] BT = new JButton[ButtonNum];

	private Vector<String> Head = new Vector<String>();
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane ScPane;
	private JPanel logpanel;
	private JButton Adexit2;

	public void logtable() {
		Adexit2 = new JButton("������ �޴�");
		model = new DefaultTableModel(Head, 0);
		table = new JTable(model);
		Vector<String> cnt = new Vector<String>();
		cnt = AccountDB.ViewLog();
		for (int i = 0; i < cnt.size(); i++) {
			Vector<String> tuple = new Vector<String>();
			tuple.add(cnt.get(i));
			model.addRow(tuple);
		}

		logpanel = new JPanel();
		logpanel.setLayout(new BoxLayout(logpanel, BoxLayout.Y_AXIS));
		ScPane = new JScrollPane(table);
		ScPane.setPreferredSize(new Dimension(700, 450));
		logpanel.add(ScPane);
		logpanel.add(Adexit2);

		Adexit2.addActionListener(this);

		menu.setVisible(false);
		FR.add(logpanel);
		logpanel.setVisible(true);
		FR.revalidate();
	}

	public GUI() {
		// �г� ���̾ƿ� ����
		GridBagConstraints[] GBC = new GridBagConstraints[ButtonNum + 2];
		GridBagLayout GBL = new GridBagLayout();
		Head.add("�ŷ�����");
		mainPN = new JPanel();
		mainPN.setLayout(GBL);
		// mainPN
		mainLB = new JLabel("K BANK");
		mainLB.setOpaque(true);
		mainLB.setBackground(new Color(27, 41, 129, 255));
		mainLB.setForeground(new Color(255, 255, 255, 255));
		mainLB.setHorizontalAlignment(JLabel.CENTER);
		mainLB.setFont(new Font("���ʷҵ���", Font.BOLD, 43));
		GBC[6] = new GridBagConstraints();
		GBC[6].gridx = 0;
		GBC[6].gridy = 0;
		GBC[6].gridwidth = 4;
		GBC[6].gridheight = 1;
		GBC[6].weightx = 1;
		GBC[6].weighty = 1;
		GBC[6].fill = GridBagConstraints.BOTH;
		mainPN.add(mainLB, GBC[6]);

		// ��ư���
		for (int i = 0; i < ButtonNum; i++) {
			BT[i] = new JButton(menuText[i]);
			BT[i].setBackground(new Color(72, 145, 217, 255));
			BT[i].setForeground(new Color(255, 255, 255, 255));
			BT[i].setFont(new Font("���ʷҵ���", Font.BOLD, 25));
		}

		for (int i = 0; i < ButtonNum; i++) {
			GBC[i] = new GridBagConstraints();

			GBC[i].gridwidth = 1;
			GBC[i].gridheight = 1;
			GBC[i].weightx = 1;
			GBC[i].weighty = 1;
			GBC[i].fill = GridBagConstraints.BOTH;
		}
		GBC[0].gridx = 0;
		GBC[0].gridy = 1;

		GBC[1].gridx = 0;
		GBC[1].gridy = 2;

		GBC[2].gridx = 0;
		GBC[2].gridy = 3;

		GBC[3].gridx = 3;
		GBC[3].gridy = 1;

		GBC[4].gridx = 3;
		GBC[4].gridy = 2;

		GBC[5].gridx = 3;
		GBC[5].gridy = 3;

		for (int i = 0; i < ButtonNum; i++) {
			mainPN.add(BT[i], GBC[i]);
		}
		// Main Image ���


		for (int i = 0; i < ButtonNum; i++) {
			BT[i].addActionListener(this);
		}

		select.addActionListener(this);
		Ad_select.addActionListener(this);
		trans_select.addActionListener(this);
		exit.addActionListener(this);
		exit0.addActionListener(this);
		exit3.addActionListener(this);
		exit4.addActionListener(this);

		getFrame();
		setpanel();
	}

	public void getFrame() {
		FR.setTitle("K BANK ATM GUI System");
		FR.setSize(800, 500);
		FR.setLocationRelativeTo(null);
		FR.setVisible(true);
		FR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setpanel() {
		FR.add(mainPN);
	}

	public void checkID() {
		getID = new JTextField(10);
		getPW = new JPasswordField(10);
		CheckID = new JPanel();
		CheckID.setLayout(null);
		CheckID.setBackground(new Color(193, 208, 227, 255));
		checkLB = new JLabel("��������");
		checkLB.setOpaque(true);
		checkLB.setBackground(new Color(193, 208, 227, 255));
		checkLB.setHorizontalAlignment(JLabel.CENTER);
		checkLB.setFont(new Font("���ʷҵ���", Font.BOLD, 35));
		checkLB.setBounds(100, 50, 150, 50);
		CheckID.add(checkLB);

		UserID.setOpaque(true);
		UserID.setBackground(new Color(193, 208, 227, 255));
		UserID.setHorizontalAlignment(JLabel.CENTER);
		UserID.setFont(new Font("���ʷҵ���", Font.BOLD, 15));
		UserID.setBounds(300, 130, 200, 30);
		CheckID.add(UserID);

		getID.setBounds(300, 160, 200, 30);
		CheckID.add(getID);

		UserPW.setOpaque(true);
		UserPW.setBackground(new Color(193, 208, 227, 255));
		UserPW.setHorizontalAlignment(JLabel.CENTER);
		UserPW.setFont(new Font("���ʷҵ���", Font.BOLD, 15));
		UserPW.setBounds(300, 190, 200, 30);
		CheckID.add(UserPW);

		getPW.setBounds(300, 220, 200, 30);
		CheckID.add(getPW);

		select.setBounds(100, 300, 100, 50);
		exit.setBounds(600, 300, 100, 50);
		CheckID.add(select);
		CheckID.add(exit);
	}

	public void getdeposit() {
		depositPN = new JPanel();
		depositPN.setLayout(null);
		depositPN.setBackground(Color.WHITE);

		depositLB = new JLabel("���� �Ա�");
		depositLB.setOpaque(true);
		depositLB.setBackground(Color.WHITE);
		depositLB.setHorizontalAlignment(JLabel.CENTER);
		depositLB.setFont(new Font("���ʷҵ���", Font.BOLD, 35));
		depositLB.setBounds(100, 50, 150, 50);
		depositPN.add(depositLB);

		depositValue = new JTextField(20);
		depositValue.setBounds(300, 200, 200, 50);
		depositPN.add(depositValue);

		depositBT = new JButton("�Ա� Ȯ��");
		depositBT.setBounds(100, 300, 100, 50);
		depositPN.add(depositBT);

		mainBackBT = new JButton("����ȭ��");
		mainBackBT.setBounds(600, 300, 100, 50);
		depositPN.add(mainBackBT);

		mainBackBT.addActionListener(this);
		depositBT.addActionListener(this);
		// deposit pn ��
	}

	public void getwithdraw() {
		// withdraw PN
		withdrawPN = new JPanel();
		withdrawPN.setLayout(null);
		withdrawPN.setBackground(Color.WHITE);

		withdrawLB = new JLabel("���� ���");
		withdrawLB.setOpaque(true);
		withdrawLB.setBackground(Color.WHITE);
		withdrawLB.setHorizontalAlignment(JLabel.CENTER);
		withdrawLB.setFont(new Font("���ʷҵ���", Font.BOLD, 35));
		withdrawLB.setBounds(100, 50, 150, 50);
		withdrawPN.add(withdrawLB);

		withdrawValue = new JTextField(20);
		withdrawValue.setBounds(300, 200, 200, 50);
		withdrawPN.add(withdrawValue);

		withdrawBT = new JButton("��� Ȯ��");
		withdrawBT.setBounds(100, 300, 100, 50);
		withdrawPN.add(withdrawBT);

		mainBackBT2 = new JButton("���� ȭ��");
		mainBackBT2.setBounds(600, 300, 100, 50);
		withdrawPN.add(mainBackBT2);

		mainBackBT2.addActionListener(this);
		withdrawBT.addActionListener(this);
		// withdraw PN ��
	}

	public void getbalance() {
		UserAccount = new JLabel("���� ��ȸ");
		UserBal = new JLabel("�ܾ�");
		UserValue = new JLabel(User_account.getBalance() + "��");
		GetBalance = new JPanel();
		GetBalance.setLayout(null);
		GetBalance.setBackground(Color.WHITE);
		UserAccount.setHorizontalAlignment(JLabel.CENTER);
		UserAccount.setFont(new Font("���ʷҵ���", Font.BOLD, 35));
		UserAccount.setBounds(100, 50, 150, 50);
		UserAccount.setBackground(Color.WHITE);

		GetBalance.add(UserAccount);

		UserBal.setHorizontalAlignment(JLabel.CENTER);
		UserBal.setFont(new Font("���ʷҵ���", Font.BOLD, 20));
		UserBal.setBounds(300, 150, 150, 50);
		UserBal.setBackground(Color.WHITE);
		GetBalance.add(UserBal);

		UserValue.setHorizontalAlignment(JLabel.CENTER);
		UserValue.setFont(new Font("���ʷҵ���", Font.BOLD, 20));
		UserValue.setBounds(300, 200, 150, 50);
		UserValue.setBackground(Color.WHITE);
		GetBalance.add(UserValue);

		exit0.setBounds(500, 400, 100, 30);
		GetBalance.add(exit0);
		CheckID.setVisible(false);
		FR.add(GetBalance);
		GetBalance.setVisible(true);
		FR.revalidate();
	}

	public void transit() {
		Trans = new JPanel();
		BorderLayout bl = new BorderLayout();
		Trans.setBackground(Color.WHITE);
		Trans.setLayout(bl);
		JPanel namePN = new JPanel();
		namePN.setLayout(new FlowLayout(FlowLayout.LEFT));
		namePN.setBackground(Color.WHITE);
		transitLB = new JLabel("    ���� ��ü");
		transitLB.setOpaque(true);
		transitLB.setBackground(Color.WHITE);
		transitLB.setHorizontalAlignment(JLabel.CENTER);
		transitLB.setFont(new Font("���ʷҵ���", Font.BOLD, 35));
		namePN.add(transitLB);
		Trans.add(namePN, BorderLayout.NORTH);

		amountNo = new JTextField(10);
		accountNo = new JTextField(10);

		JLabel jump = new JLabel("����������������������������������������������������");

		JPanel balPN = new JPanel();
		balPN.setLayout(new FlowLayout(FlowLayout.CENTER));
		balPN.setBackground(Color.WHITE);
		AccountLabel.setOpaque(true);
		AccountLabel.setBackground(Color.WHITE);
		AccountLabel.setHorizontalAlignment(JLabel.CENTER);
		AccountLabel.setFont(new Font("���ʷҵ���", Font.BOLD, 15));
		balPN.add(AccountLabel);
		balPN.add(accountNo);

		AmountLabel.setOpaque(true);
		AmountLabel.setBackground(Color.WHITE);
		AmountLabel.setHorizontalAlignment(JLabel.CENTER);
		AmountLabel.setFont(new Font("���ʷҵ���", Font.BOLD, 15));
		balPN.add(AmountLabel);

		balPN.add(amountNo);

		Bal = new JLabel("�ܾ� : " + User_account.getBalance() + "         ");
		Bal.setOpaque(true);
		Bal.setBackground(Color.WHITE);
		Bal.revalidate();
		balPN.revalidate();

		both = new JPanel();
		both.setBackground(Color.WHITE);
		both.setLayout(new BoxLayout(both, BoxLayout.Y_AXIS));
		both.add(balPN);
		both.add(Bal);

		Trans.add(both, BorderLayout.CENTER);

		JPanel selectPN = new JPanel();
		selectPN.setLayout(new FlowLayout(FlowLayout.CENTER));

		selectPN.add(trans_select);
		selectPN.setBackground(Color.WHITE);

		selectPN.add(jump);
		selectPN.add(exit3);
		Trans.add(selectPN, BorderLayout.SOUTH);

		CheckID.setVisible(false);
		FR.add(Trans);
		Trans.setVisible(true);
		FR.revalidate();
	}

	public void AdminCheck() {
		getID = new JTextField(10);
		getPW = new JPasswordField(10);
		CheckID = new JPanel();
		CheckID.setLayout(null);
		CheckID.setBackground(new Color(193, 208, 227, 255));
		checkLB2 = new JLabel("������ ����");
		checkLB2.setOpaque(true);
		checkLB2.setBackground(new Color(193, 208, 227, 255));
		checkLB2.setHorizontalAlignment(JLabel.CENTER);
		checkLB2.setFont(new Font("���ʷҵ���", Font.BOLD, 35));
		checkLB2.setBounds(100, 50, 200, 50);
		CheckID.add(checkLB2);
		AdminID.setOpaque(true);
		AdminID.setBackground(new Color(193, 208, 227, 255));
		AdminID.setHorizontalAlignment(JLabel.CENTER);
		AdminID.setFont(new Font("���ʷҵ���", Font.BOLD, 15));
		AdminID.setBounds(300, 130, 200, 30);
		CheckID.add(AdminID);

		getID.setBounds(300, 160, 200, 30);
		CheckID.add(getID);

		UserPW.setOpaque(true);
		UserPW.setBackground(new Color(193, 208, 227, 255));
		UserPW.setHorizontalAlignment(JLabel.CENTER);
		UserPW.setFont(new Font("���ʷҵ���", Font.BOLD, 15));
		UserPW.setBounds(300, 190, 200, 30);
		CheckID.add(UserPW);

		getPW.setBounds(300, 220, 200, 30);
		CheckID.add(getPW);

		Ad_select.setBounds(100, 300, 100, 50);
		exit.setBounds(600, 300, 100, 50);
		CheckID.add(Ad_select);
		CheckID.add(exit);
	}

	public void Admain() {
		menu = new JPanel();
		menu.setLayout(null);
		menu.setBackground(Color.WHITE);
		AdminLB = new JLabel("������ �޴�");
		AdminLB.setOpaque(true);
		AdminLB.setBackground(Color.WHITE);
		AdminLB.setHorizontalAlignment(JLabel.CENTER);
		AdminLB.setFont(new Font("���ʷҵ���", Font.BOLD, 35));
		AdminLB.setBounds(100, 50, 200, 50);
		menu.add(AdminLB);

		LogB = new JButton("�ŷ�������ȸ");
		LogB.setBounds(100, 150, 166, 80);
		LogB.setFont(new Font("���ʷҵ���", Font.BOLD, 20));
		LogB.setBackground(new Color(193, 208, 227, 255));
		ATMcheckB = new JButton("ATM �ݾ�Ȯ��");
		ATMcheckB.setBounds(320, 150, 166, 80);
		ATMcheckB.setFont(new Font("���ʷҵ���", Font.BOLD, 20));
		ATMcheckB.setBackground(new Color(193, 208, 227, 255));
		ATMInB = new JButton("ATM �ݾ��Ա�");
		ATMInB.setBounds(532, 150, 166, 80);
		ATMInB.setFont(new Font("���ʷҵ���", Font.BOLD, 20));
		ATMInB.setBackground(new Color(193, 208, 227, 255));
		exit4.setBounds(600, 300, 100, 50);
		menu.add(LogB);
		menu.add(ATMcheckB);
		menu.add(ATMInB);
		menu.add(exit4);

		LogB.addActionListener(this);
		ATMcheckB.addActionListener(this);
		ATMInB.addActionListener(this);

		CheckID.setVisible(false);
		FR.add(menu);
		menu.setVisible(true);
		FR.revalidate();
	}

	public void ATMBal() {
		getATMbal = new JPanel();
		getATMbal.setLayout(null);
		getATMbal.setBackground(Color.WHITE);

		PlusATM = new JLabel("ATM ���� ����");
		PlusATM.setOpaque(true);
		PlusATM.setBackground(Color.WHITE);
		PlusATM.setHorizontalAlignment(JLabel.CENTER);
		PlusATM.setFont(new Font("���ʷҵ���", Font.BOLD, 35));
		PlusATM.setBounds(100, 25, 300, 50);
		getATMbal.add(PlusATM);

		inputT = new JLabel("�߰��� ���� ���");
		inputT.setOpaque(true);
		inputT.setBackground(Color.WHITE);
		inputT.setHorizontalAlignment(JLabel.CENTER);
		inputT.setFont(new Font("���ʷҵ���", Font.BOLD, 15));
		inputT.setBounds(250, 100, 300, 50);

		tenT = new JTextField(10);
		tenT.setBackground(Color.WHITE);
		tenT.setHorizontalAlignment(JLabel.CENTER);
		tenT.setFont(new Font("���ʷҵ���", Font.BOLD, 15));
		tenT.setBounds(250, 150, 300, 50);

		inputF = new JLabel("�߰��� ������ ���");
		inputF.setOpaque(true);
		inputF.setBackground(Color.WHITE);
		inputF.setHorizontalAlignment(JLabel.CENTER);
		inputF.setFont(new Font("���ʷҵ���", Font.BOLD, 15));
		inputF.setBounds(250, 200, 300, 50);
		fiftyT = new JTextField(10);
		fiftyT.setBackground(Color.WHITE);
		fiftyT.setHorizontalAlignment(JLabel.CENTER);
		fiftyT.setFont(new Font("���ʷҵ���", Font.BOLD, 15));
		fiftyT.setBounds(250, 250, 300, 50);

		Input = new JButton("Ȯ��");
		Input.setBounds(600, 400, 100, 50);
		Adexit = new JButton("�����ڸ޴�");
		Adexit.setBounds(100, 400, 100, 50);

		getATMbal.add(inputT);
		getATMbal.add(tenT);
		getATMbal.add(inputF);
		getATMbal.add(fiftyT);
		getATMbal.add(Input);
		getATMbal.add(Adexit);

		Input.addActionListener(this);
		Adexit.addActionListener(this);

		menu.setVisible(false);
		FR.add(getATMbal);
		getATMbal.setVisible(true);
		FR.revalidate();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Adexit) {
			menu.setVisible(true);
			getATMbal.setVisible(false);
			FR.revalidate();
		}
		if (e.getSource() == Adexit2) {
			menu.setVisible(true);
			logpanel.setVisible(false);
			FR.revalidate();
		}
		if (e.getSource() == Input) {
			int input_t = 0;
			int input_f = 0;
			String t_string = tenT.getText();
			String f_string = fiftyT.getText();
			boolean flag = false;

			if (t_string.isEmpty() || f_string.isEmpty())
				JOptionPane.showMessageDialog(null, "���� �Է��� ���� �ʾҽ��ϴ�.");
			if (!t_string.isEmpty()) {
				input_t = Integer.parseInt(t_string);
				flag = true;
			}
			if (!f_string.isEmpty()) {
				input_f = Integer.parseInt(f_string);
				flag = true;
			}

			if (flag) {
				setBalanceATM(input_t, input_f);
				JOptionPane.showMessageDialog(null, "�Ա� �Ϸ�");
			}
		}

		if (e.getSource() == BT[0]) {
			frame = 0;
			checkID();
			mainPN.setVisible(false);
			FR.add(CheckID);
			CheckID.setVisible(true);
			FR.revalidate();
		}
		if (e.getSource() == BT[1]) {
			frame = 1;
			checkID();
			mainPN.setVisible(false);
			FR.add(CheckID);
			CheckID.setVisible(true);
			FR.revalidate();
		}
		if (e.getSource() == BT[2]) {
			System.exit(0);
		}
		if (e.getSource() == BT[3]) {
			frame = 3;
			checkID();
			mainPN.setVisible(false);
			FR.add(CheckID);
			CheckID.setVisible(true);
			FR.revalidate();
		}
		if (e.getSource() == BT[4]) {
			frame = 4;
			checkID();
			mainPN.setVisible(false);
			FR.add(CheckID);
			CheckID.setVisible(true);
			FR.revalidate();
		}
		if (e.getSource() == BT[5]) {
			frame = 5;
			AdminCheck();
			mainPN.setVisible(false);
			FR.add(CheckID);
			CheckID.setVisible(true);
			FR.revalidate();
		}
		// ������
		if (e.getSource() == LogB) {
			logtable();
			AccountDB.ViewLog();
		}
		if (e.getSource() == ATMcheckB) {
			JOptionPane.showMessageDialog(null,
					"ATM �ܾ�:" + getBalanceATM() + "��\n���� ��: " + tenThousand + "��" + "\t ������ ��: " + fiftyThousand + "��");
		}
		if (e.getSource() == ATMInB) {
			ATMBal();
		}
		if (e.getSource() == select) {
			int id = 0;
			String idstring = getID.getText();
			String pw = getPW.getText();
			boolean flag = false;

			if (idstring.isEmpty() && pw.isEmpty())
				JOptionPane.showMessageDialog(null, "���¹�ȣ, ��й�ȣ ���Է� �Դϴ�.");
			else if (idstring.isEmpty())
				JOptionPane.showMessageDialog(null, "���¹�ȣ ���Է� �Դϴ�.");
			else if (pw.isEmpty())
				JOptionPane.showMessageDialog(null, "��й�ȣ ���Է��Դϴ�.");
			else {
				id = Integer.parseInt(idstring);
				User_account = new Account(id, pw);
				flag = true;
			}

			if (flag && !Identification.checkID(id, pw)) // ����Ȯ��
				JOptionPane.showMessageDialog(null, "��ġ�ϴ� ���°� �����ϴ�. ID/PW Ȯ�����ּ���.");
			else if (!flag)
				;
			else {
				User_account = Identification.getUpdatedAccount();

				for (int i = 0; i < AccountDB.account.size(); i++) {
					if (User_account.getAccountID() == AccountDB.account.get(i).getAccountID()) {
						if (AccountDB.account.get(i).duplicate) {
							AccountDB.account.get(i).duplicate = false;
							if (frame == 0) {
								getbalance();
							}
							if (frame == 1) {
								getdeposit();
								CheckID.setVisible(false);
								FR.add(depositPN);

								depositPN.setVisible(true);
								JOptionPane.showMessageDialog(null, "�ܾ� : " + User_account.getBalance());
								FR.revalidate();
							}
							if (frame == 2)
								;
							if (frame == 3) {
								if (User_account.getAccountType() == 1) {
									transit();
								} else { 
									JOptionPane.showMessageDialog(null, "���⿹�� �����Դϴ�.");
									for (int j = 0; j < AccountDB.account.size(); j++) {
										if (User_account.getAccountID() == AccountDB.account.get(j).getAccountID())
											AccountDB.account.get(j).duplicate = true;
									}
								}
							}
							if (frame == 4) {
								getwithdraw();
								CheckID.setVisible(false);
								FR.add(withdrawPN);
								withdrawPN.setVisible(true);
								JOptionPane.showMessageDialog(null, "�ܾ� : " + User_account.getBalance());
								FR.revalidate();
							}

						} else {
							JOptionPane.showMessageDialog(null, "������� ���� �Դϴ�.");
						}
					}
				}
			}

		}
		if (e.getSource() == Ad_select) {
			int id = 0;
			int pw = 0;
			String idstring = getID.getText();
			String pwstring = getPW.getText();
			boolean flag = false;

			if (idstring.isEmpty() && pwstring.isEmpty())
				JOptionPane.showMessageDialog(null, "ID, ��й�ȣ ���Է� �Դϴ�.");
			else if (idstring.isEmpty())
				JOptionPane.showMessageDialog(null, "ID ���Է� �Դϴ�.");
			else if (pwstring.isEmpty())
				JOptionPane.showMessageDialog(null, "��й�ȣ ���Է��Դϴ�.");
			else {
				id = Integer.parseInt(idstring);
				pw = Integer.parseInt(pwstring);
				flag = true;
			}

			if (flag) { // ����Ȯ��
				if (id != 1234 || pw != 5678)
					JOptionPane.showMessageDialog(null, "�߸��� ID/PW �Դϴ�.");
				else {
					Admain();
				}
			}
		}
		if (e.getSource() == trans_select) {
			int amount = 0;
			int accountID = 0;
			String amString = amountNo.getText();
			String acIdString = accountNo.getText();
			boolean flag = false;

			if (amString.isEmpty() && acIdString.isEmpty())
				JOptionPane.showMessageDialog(null, "���¹�ȣ, ��й�ȣ ���Է� �Դϴ�.");
			else if (amString.isEmpty())
				JOptionPane.showMessageDialog(null, "��ü�� �ݾ��� �Է��ϼ���.");
			else if (acIdString.isEmpty())
				JOptionPane.showMessageDialog(null, "���¹�ȣ ���Է� �Դϴ�.");
			else {
				amount = Integer.parseInt(amString);
				accountID = Integer.parseInt(acIdString);
				flag = true;
			}

			// 
			if (flag) {
				Transfer trans = new Transfer();
				trans.transfer(amount, accountID);
				boolean check = trans.getchecker();
				if (check && accountID != User_account.getAccountID()) {
					both.remove(Bal);
					Bal = new JLabel("�ܾ� : " + User_account.getBalance());
					Bal.setOpaque(true);
					Bal.setBackground(Color.WHITE);
					Bal.setHorizontalAlignment(JLabel.CENTER);
					both.add(Bal);

					Trans.add(both, BorderLayout.CENTER);
					FR.revalidate();
					JOptionPane.showMessageDialog(null, accountID + " ���� ��ü�Ϸ�");
				} 
			}
		}
		if (e.getSource() == exit) {
			CheckID.setVisible(false);
			mainPN.setVisible(true);
			FR.revalidate();
		}
		if (e.getSource() == exit0) {
			CheckID.setVisible(false);
			GetBalance.setVisible(false);
			mainPN.setVisible(true);
			FR.revalidate();
			for (int i = 0; i < AccountDB.account.size(); i++) {
				if (User_account.getAccountID() == AccountDB.account.get(i).getAccountID())
					AccountDB.account.get(i).duplicate = true;
			}
		}
		if (e.getSource() == exit3) {
			Trans.setVisible(false);
			mainPN.setVisible(true);
			FR.revalidate();
			for (int i = 0; i < AccountDB.account.size(); i++) {
				if (User_account.getAccountID() == AccountDB.account.get(i).getAccountID())
					AccountDB.account.get(i).duplicate = true;
			}
		}
		if (e.getSource() == exit4) {
			menu.setVisible(false);
			mainPN.setVisible(true);
			FR.revalidate();
		}

		if (e.getSource() == mainBackBT) {
			CheckID.setVisible(false);
			depositPN.setVisible(false);
			mainPN.setVisible(true);
			FR.remove(depositPN);
			FR.revalidate();
			for (int i = 0; i < AccountDB.account.size(); i++) {
				if (User_account.getAccountID() == AccountDB.account.get(i).getAccountID())
					AccountDB.account.get(i).duplicate = true;
			}
		}
		if (e.getSource() == mainBackBT2) {
			CheckID.setVisible(false);
			withdrawPN.setVisible(false);
			mainPN.setVisible(true);
			FR.remove(withdrawPN);
			FR.revalidate();
			for (int i = 0; i < AccountDB.account.size(); i++) {
				if (User_account.getAccountID() == AccountDB.account.get(i).getAccountID())
					AccountDB.account.get(i).duplicate = true;
			}
		}

		if (e.getSource() == depositBT) {
			/*
			if (User_account.getAccountType() == 0) {
				// JOptionPane.showMessageDialog(null, "���⿹�� �����Դϴ�.");
			}*/
			int amount = 0;
			String deString = depositValue.getText();
			boolean flag = false;

			if (deString.isEmpty())
				JOptionPane.showMessageDialog(null, "�Ա��� �Է����� �����̽��ϴ�.");
			else {
				amount = Integer.parseInt(deString);
				flag = true;
			}

			if (flag) {
				if (amount % 10000 == 0) {
					Deposit dep = new Deposit();
					dep.deposit(amount);
				} else {
					JOptionPane.showMessageDialog(null, "���� �Ǵ� �������� �Ա� �����մϴ�.");
				}
			}
		}
		if (e.getSource() == withdrawBT) {
			if (User_account.getAccountType() == 1) {
				int amount = 0;
				String wiString = withdrawValue.getText();
				boolean flag = false;

				if (wiString.isEmpty())
					JOptionPane.showMessageDialog(null, "�Ա��� �Է����� �����̽��ϴ�.");
				else {
					amount = Integer.parseInt(wiString);
					flag = true;
				}

				if (flag) {
					if (amount % 10000 == 0) {
						Withdraw with = new Withdraw();
						with.withdraw(amount);
					} else {
						JOptionPane.showMessageDialog(null, "���� �Ǵ� �������� ��� �����մϴ�.");
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "���⿹�� �����Դϴ�.");
			}
		}

	}

}