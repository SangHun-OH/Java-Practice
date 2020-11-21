package ATM;
//계좌 
public class Account {

	private int AccountNo; // 계좌번호
	private String pw; // 비밀번호
	private int accountType; // 계좌유형 (입출금, 정기예금)
	private int balance; // 잔액

	public boolean duplicate = true; // 중복방지용 (true: 접근 가능)
	// 외부에서 값을 바꿔줘야 하기때문에 public 선언

	public Account(int Type, int id, String password, int money) {
		this.accountType = Type; 
		this.AccountNo = id;
		this.pw = password;
		this.balance = money;
	}

	public Account(int Num, String password) { // 고객의 입력으로 만들어진 계좌
		this.pw = password;
		this.AccountNo = Num;
	}

	public int getAccountID() { //외부참조를 위해 전부 public
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
	public void setBalance(int val) {  //ATM에서 잔액을 바꿔줘야하기에 잔액 설정 함수 선언
		this.balance +=val;
	}
}