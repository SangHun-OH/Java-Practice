package ATM;
//���� 
public class Account {

	private int AccountNo; // ���¹�ȣ
	private String pw; // ��й�ȣ
	private int accountType; // �������� (�����, ���⿹��)
	private int balance; // �ܾ�

	public boolean duplicate = true; // �ߺ������� (true: ���� ����)
	// �ܺο��� ���� �ٲ���� �ϱ⶧���� public ����

	public Account(int Type, int id, String password, int money) {
		this.accountType = Type; 
		this.AccountNo = id;
		this.pw = password;
		this.balance = money;
	}

	public Account(int Num, String password) { // ���� �Է����� ������� ����
		this.pw = password;
		this.AccountNo = Num;
	}

	public int getAccountID() { //�ܺ������� ���� ���� public
		return this.AccountNo;
	}

	public int getAccountType() {
		return this.accountType;
	}

	public int getBalance() {
		return this.balance;
	}

	public String getPw() {
		return this.pw;
	}
	public void setBalance(int val) {  //ATM���� �ܾ��� �ٲ�����ϱ⿡ �ܾ� ���� �Լ� ����
		this.balance +=val;
	}
}