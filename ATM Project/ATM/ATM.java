package ATM;

public class ATM {
   protected static Account User_account; // ATM�� ���� ���� account
   
   protected static int tenThousand = 1000;
   protected static int fiftyThousand = 200;

   protected static void setBalanceATM(int ten, int five) {
      tenThousand += ten;
      fiftyThousand += five;
   }

   protected static int getBalanceATM() {
      return tenThousand * 10000 + fiftyThousand * 50000;
   }

   public static void main(String[] args) { 
      AccountDB.init_Account(); // DB �� ���� ��
      new GUI(); //GUI MAIN ȣ��
   }

}