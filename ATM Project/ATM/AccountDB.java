package ATM;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class AccountDB {
   public static List<Account> account = new ArrayList<Account>(); //ATM(�ܺ� Ŭ����)���� �����ϱ� ���� public
   private static Vector<String> logs = new Vector<String>(); //log�� �������� �Ұ�

   public static void init_Account() { //DB �� ���� ���� (��������,���¹�ȣ,��й�ȣ,�ܾ�)
      account.add(new Account(1,11045401, "1111", 80000));
      account.add(new Account(0,11045402, "0000", 150000));
      account.add(new Account(1,11045403, "1313", 50000));
      account.add(new Account(1,11045404, "1234", 0));
      account.add(new Account(1,11045405, "9999", 20000000));
      account.add(new Account(1,112211, "1111", 20000000));
      account.add(new Account(1,112233, "1111", 20000000));
   }
   
   public static void TransactionLog(String log) { //�Էµ� �α� ���
      logs.add(log);
   }
   public static Vector<String> ViewLog() { //�α� ��ȸ
      return logs;  
   }
}