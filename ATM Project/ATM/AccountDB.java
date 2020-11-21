package ATM;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class AccountDB {
   public static List<Account> account = new ArrayList<Account>(); //ATM(외부 클래스)에서 수정하기 위해 public
   private static Vector<String> logs = new Vector<String>(); //log는 임의조작 불가

   public static void init_Account() { //DB 내 계좌 정보 (계좌유형,계좌번호,비밀번호,잔액)
      account.add(new Account(1,11045401, "1111", 80000));
      account.add(new Account(0,11045402, "0000", 150000));
      account.add(new Account(1,11045403, "1313", 50000));
      account.add(new Account(1,11045404, "1234", 0));
      account.add(new Account(1,11045405, "9999", 20000000));
      account.add(new Account(1,112211, "1111", 20000000));
      account.add(new Account(1,112233, "1111", 20000000));
   }
   
   public static void TransactionLog(String log) { //입력된 로그 기록
      logs.add(log);
   }
   public static Vector<String> ViewLog() { //로그 조회
      return logs;  
   }
}