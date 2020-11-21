package pokerGame;

import java.util.Arrays;

public class Game {
   public static final int cardCount = 5;
   public static int userCount;
   protected static User[] user;
   protected User winner;

   public static void main(String[] args) {
      /*
       * userCount = 2; user = new User[userCount]; Deck deck = new Deck(); // user 패
       * for (int i = 0; i < 2; i++) { user[i] = new User(); // userCount 만큼의 user //
       * deck.pushCard(user[i]); } // Card[] userDeck = new Card[Game.cardCount];
       * Card[] userDeck1 = new Card[Game.cardCount];
       * 
       * userDeck[0] = new Card("♣", 2); userDeck[1] = new Card("♣", 2); userDeck[2] =
       * new Card("♣", 1); userDeck[3] = new Card("♣", 1); userDeck[4] = new Card("♣",
       * 8); user[0].setDeck(userDeck); userDeck1[0] = new Card("♣", 6); userDeck1[1]
       * = new Card("♣", 6); userDeck1[2] = new Card("♥", 6); userDeck1[3] = new
       * Card("♣", 10); userDeck1[4] = new Card("♣", 10); user[1].setDeck(userDeck1);
       * // // user에게 카드 나눠줌. } Game my = new Game(); my.checkPoint();
       * my.checkWinner(); // User who = comepareRank(user[0],user[1]); //
       * System.out.println("승자 " +who.getCard(1).getRank());
       */
      new GUI();
   }

   public void checkPair() {
      // for(int c = 0; c < cardCount; c++) {
      // System.out.print(user[0].getCard(c).getShape()+user[0].getCard(c).getRank()+"
      // "); } System.out.println();

      for (int i = 0; i < userCount; i++) {
         int pairCount = 0;
         for (int j = 0; j < cardCount; j++) {
            int sameRank = -1;
            for (int k = 0; k < cardCount; k++) {
               if (user[i].getCard(j).getRank() == user[i].getCard(k).getRank()) {
                  sameRank++;

                  if (sameRank == 1) {
                     pairCount++;
                  }
               }
            }
            // System.out.println("페어카운트:"+pairCount);
            if (sameRank == 0) {
               if (checkStraight(user[i]) == true) { // straight 확인
                  user[i].setStraight(1);
               }
            } else if (sameRank == 1) {
               if (pairCount == 1) {
                  user[i].setPair(1, user[i].getCard(j).getRank());
               } else if (pairCount == 4) {
                  user[i].setPair(2, user[i].getCard(j).getRank());
               } else if (pairCount == 5) {
                  user[i].setTrips(1, user[i].getCard(j).getRank());
                  user[i].setPair(1, user[i].getCard(j).getRank());
               }
            } else if (sameRank == 2) {
               if (pairCount == 3) {
                  user[i].setTrips(1, user[i].getCard(j).getRank());
               } else if (pairCount == 5) {
                  user[i].setTrips(1, user[i].getCard(j).getRank());
                  user[i].setPair(1, user[i].getCard(j).getRank());
               }
            } else if (sameRank == 3) {
               user[i].setQuads(1, user[i].getCard(j).getRank());
            }
            System.out.println("sameRank : " + sameRank + " pairCountTop : " + pairCount);
         }
      }
   }

   public boolean checkStraight(User user) {
      for (int i = 0; i < userCount; i++) {
         if (user.getCard(0).getRank() == 2 && user.getCard(1).getRank() == 3 && user.getCard(2).getRank() == 4
               && user.getCard(3).getRank() == 5 && user.getCard(4).getRank() == 14) {
            // userDeck = { A(14) 5 4 3 2 } 인 경우 : A = 1.
            user.getCard(0).setRank(1);
            user.setStraight(1);
            return true;
         }

         int sameRank = 0;
         for (int j = 0; j < cardCount - 1; j++) {

            // System.out.println("출력:"+ (user.getCard(j+1).getRank()));
            if (user.getCard(j).getRank() + 1 == user.getCard(j + 1).getRank()) { // straight >> true, not
               // straight >> return false.
               sameRank++;
               // System.out.println("출력:" + sameRank);
            }
         }
         if (sameRank == 4) {
            user.setStraight(1);
            return true;
         }
      }
      return false;
   }

   public void checkFlush() {
      for (int i = 0; i < userCount; i++) {
         int sameShape = 0;
         for (int j = 0; j + 1 < cardCount; j++) {
            if (user[i].getCard(j).getShape().equals(user[i].getCard(j + 1).getShape())) {
               sameShape++;
            }
         }
         if (sameShape == 4) {
            user[i].setFlush(1);
         }
      }
   }

   public void checkPoint() {

      checkPair();
      checkFlush();
      /*
       * for (int c = 0; c < cardCount; c++) {
       * System.out.print(user[0].getCard(c).getShape() + user[0].getCard(c).getRank()
       * + " "); } System.out.print("\n"); for (int c = 0; c < cardCount; c++) {
       * 
       * System.out.print(user[1].getCard(c).getShape() + user[1].getCard(c).getRank()
       * + " "); } System.out.println("\n pair : " + user[0].getPair() + " flush : " +
       * user[0].getFlush()); System.out.println("\n pair : " + user[1].getPair() +
       * " flush : " + user[1].getFlush());
       */

      for (int i = 0; i < userCount; i++) {
         if (user[i].getPair() == 0) {
            if (user[i].getFlush() == 1) {
               if (user[i].getStraight() == 1) {
                  if (user[i].getCard(0).getRank() == 10) {
                     user[i].setPoint(10); // Royal Straight Flush
                  } else {
                     user[i].setPoint(9); // Straight Flush
                  }
               } else {
                  user[i].setPoint(6); // Flush
               }
            } else {
               if (user[i].getStraight() == 1) {
                  user[i].setPoint(5); // Straight
               } else {
                  user[i].setPoint(1); // High Card pair 0 flush 0 straight 0
               }
            }
         }
         if (user[i].getPair() == 1) {
            if (user[i].getTrips() == 1) {
               user[i].setPoint(7); // Full House
            } else {
               if (user[i].getFlush() == 1) {
                  user[i].setPoint(6); // Flush
               } else
                  user[i].setPoint(2); // Pair
            }
         }
         if (user[i].getPair() == 2) {
            if (user[i].getFlush() == 1) {
               user[i].setPoint(6); // Flush
            } else
               user[i].setPoint(3); // Two Pair
         }
         if (user[i].getTrips() == 1) {
            if (user[i].getPair() == 1) {
               user[i].setPoint(7); // Full House
            } else {
               if (user[i].getFlush() == 1) {
                  user[i].setPoint(6); // Flush
               } else
                  user[i].setPoint(4); // Trips
            }

         }
         if (user[i].getQuads() == 1) {
            user[i].setPoint(8); // Quads
         }

         System.out.println("페어 : " + user[i].getPair());
         System.out.println("트리플 : " + user[i].getTrips());

         System.out.println("point : " + user[i].getPoint());
      }

   }

   public User compareShape(User user, User user2) { // shape 비교.
      int shape1 = 0, shape2 = 0;

      if (user.getCard(0).getShape().equals("♣")) {
         shape1 = 1;
      } else if (user.getCard(0).getShape().equals("♥")) {
         shape1 = 2;
      } else if (user.getCard(0).getShape().equals("♠")) {
         shape1 = 3;
      } else if (user.getCard(0).getShape().equals("◆")) {
         shape1 = 4;
      }

      if (user2.getCard(0).getShape().equals("♣")) {
         shape2 = 1;
      } else if (user2.getCard(0).getShape().equals("♥")) {
         shape2 = 2;
      } else if (user2.getCard(0).getShape().equals("♠")) {
         shape2 = 3;
      } else if (user2.getCard(0).getShape().equals("◆")) {
         shape2 = 4;
      }

      if (shape1 > shape2) {
         return user;
      } else {
         return user2;
      }
   }

   public static User comepareRank(User user, User user2) {
      switch (user.getPoint()) {
      case 1:
         if (user.getCard(cardCount - 1).getRank() > user2.getCard(cardCount - 1).getRank()) {
            return user;
         } else if (user.getCard(cardCount - 1).getRank() < user2.getCard(cardCount - 1).getRank()) {
            return user2;
         } else {
            if (user.getCard(cardCount - 2).getRank() > user2.getCard(cardCount - 2).getRank()) {
               return user;
            } else if (user.getCard(cardCount - 2).getRank() < user2.getCard(cardCount - 2).getRank()) {
               return user2;
            } else {
               if (user.getCard(cardCount - 3).getRank() > user2.getCard(cardCount - 3).getRank()) {
                  return user;
               } else if (user.getCard(cardCount - 3).getRank() < user2.getCard(cardCount - 3).getRank()) {
                  return user2;
               } else {
                  if (user.getCard(cardCount - 4).getRank() > user2.getCard(cardCount - 4).getRank()) {
                     return user;
                  } else if (user.getCard(cardCount - 4).getRank() < user2.getCard(cardCount - 4).getRank()) {
                     return user2;
                  } else {
                     if (user.getCard(cardCount - 5).getRank() > user2.getCard(cardCount - 5).getRank()) {
                        return user;
                     } else if (user.getCard(cardCount - 5).getRank() <= user2.getCard(cardCount - 5)
                           .getRank()) {
                        return user2;
                     }
                  }
               }
            }

         }
      case 2:
         int userNum = 0, user2Num = 0;
         if (user.getPairsNum(0) > user.getPairsNum(1)) {
            userNum = user.getPairsNum(0);
         } else {
            userNum = user.getPairsNum(1);
         }
         if (user2.getPairsNum(0) > user2.getPairsNum(1)) {
            user2Num = user2.getPairsNum(0);
         } else {
            user2Num = user2.getPairsNum(1);
         }
         // System.out.println(userNum + "and" + user2Num);
         if (userNum > user2Num) {
            return user;
         } else if (userNum < user2Num) {
            return user2;
         } else {
            int[] findBig = new int[3];
            int[] findBig2 = new int[3];
            int index1 = 0;
            int index2 = 0;
            System.out.println("new 유저 페어: " + userNum + "   기존 유저 페어: " + user2Num);
            for (int i = 0; i < cardCount; i++) {
               if (user.getCard(i).getRank() != userNum) {
                  findBig[index1] = user.getCard(i).getRank();
                  index1++;
               }
               if (user2.getCard(i).getRank() != user2Num) {
                  findBig2[index2] = user2.getCard(i).getRank();
                  index2++;
               }
            }
            Arrays.sort(findBig);
            Arrays.sort(findBig2);
            // System.out.println(findBig2[0] + " !!and!! " + user2Num);
            int i = 2;
            while (true) {
               if (findBig[i] > findBig2[i]) {
                  return user;
               } else if (findBig[i] < findBig2[i]) {
                  return user2;
               } else if (findBig[i] == findBig2[i])
                  i--;
               if (i == 0)
                  return user2;
            }
         }
      case 3:
         int userNum2 = 0, user2Num2 = 0;
         int userNumS2 = 0, user2NumS2 = 0;
         // System.out.println(user.getPairsNum(0) + " !!and!! " + user.getPairsNum(1));
         // System.out.println(user2.getPairsNum(0) + " !!and!! " +
         // user2.getPairsNum(1));

         if (user.getPairsNum(0) > user.getPairsNum(1)) {
            userNum2 = user.getPairsNum(0);
         } else {
            userNum2 = user.getPairsNum(1);
         }
         if (user2.getPairsNum(0) > user2.getPairsNum(1)) {
            user2Num2 = user2.getPairsNum(0);
         } else {
            user2Num2 = user2.getPairsNum(1);
         }

         if (userNum2 > user2Num2) {
            return user;
         } else if (userNum2 < userNum2) {
            return user2;
         } else {
            if (userNum2 != user.getPairsNum(0)) {
               userNumS2 = user.getPairsNum(0);
            } else {
               userNumS2 = user.getPairsNum(1);
            }
            if (user2Num2 != user2.getPairsNum(0)) {
               user2NumS2 = user2.getPairsNum(0);
            } else {
               user2NumS2 = user2.getPairsNum(1);
            }
            if (userNumS2 > user2NumS2) {
               return user;
            } else if (userNumS2 < user2NumS2) {
               return user2;
            } else {
               int remain = 0, remain2 = 0;
               for (int i = 0; i < userCount; i++) {
                  if (user.getCard(i).getRank() != userNum2 && user.getCard(i).getRank() != userNumS2) {
                     remain = user.getCard(i).getRank();
                  }
                  if (user2.getCard(i).getRank() != user2Num2 && user2.getCard(i).getRank() != user2NumS2) {
                     remain2 = user.getCard(i).getRank();
                  }
                  if (remain > remain2) {
                     return user;
                  } else {
                     return user2;
                  }
               }
            }
         }
      case 4:
         if (user.getTripsNum() > user2.getTripsNum()) {
            return user;
         } else if (user.getTripsNum() == user2.getTripsNum()) {
            int[] notTripsNum = new int[2];
            int[] notTripsNum2 = new int[2];
            int userCardNum;
            int user2CardNum;
            int index = 0;
            for (int i = 0; i < cardCount; i++) {
               if (user.getCard(i).getRank() != user.getTripsNum()) {
                  notTripsNum[index] = user.getCard(i).getRank();
               }
               if (user2.getCard(i).getRank() != user2.getTripsNum()) {
                  notTripsNum2[index] = user2.getCard(i).getRank();
               }
               index++;
            }
            if (notTripsNum[0] > notTripsNum[1]) {
               userCardNum = notTripsNum[0];
            } else {
               userCardNum = notTripsNum[1];
            }
            if (notTripsNum2[0] > notTripsNum2[1]) {
               user2CardNum = notTripsNum2[0];
            } else {
               user2CardNum = notTripsNum2[1];
            }
            if (userCardNum > user2CardNum) {
               return user;
            } else {
               return user2;
            }
         } else {
            return user2;
         }
      case 5:
         if (user.getCard(cardCount - 1).getRank() > user2.getCard(cardCount - 1).getRank()) {
            return user;
         } else if (user.getCard(cardCount - 1).getRank() <= user2.getCard(cardCount - 1).getRank()) {
            return user2;
         }
      case 7:
         if (user.getTripsNum() > user2.getTripsNum()) {
            return user;
         } else if (user.getTripsNum() == user2.getTripsNum()) {
            int[] notTripsNum = new int[2];
            int[] notTripsNum2 = new int[2];
            int index = 0;
            int userCardNum;
            int user2CardNum;
            for (int i = 0; i < cardCount; i++) {
               if (user.getCard(i).getRank() != user.getTripsNum()
                     && user.getCard(i).getRank() != user.getTripsNum()) {
                  notTripsNum[index] = user.getCard(i).getRank();
               }
               if (user2.getCard(i).getRank() != user2.getTripsNum()
                     && user2.getCard(i).getRank() != user2.getTripsNum()) {
                  notTripsNum2[index] = user2.getCard(i).getRank();
               }
               index++;
            }
            if (notTripsNum[0] > notTripsNum[1]) {
               userCardNum = notTripsNum[0];
            } else {
               userCardNum = notTripsNum[1];
            }
            if (notTripsNum2[0] > notTripsNum2[1]) {
               user2CardNum = notTripsNum2[0];
            } else {
               user2CardNum = notTripsNum2[1];
            }
            if (userCardNum > user2CardNum) {
               return user;
            } else if (userCardNum < user2CardNum) {
               return user2;
            }
         } else {
            return user2;
         }
      case 8:
         if (user.getQuadsNum() > user2.getQuadsNum()) {
            return user;
         } else if (user.getQuadsNum() == user2.getQuadsNum()) {
            int userCardNum = 0;
            int user2CardNum = 0;
            for (int i = 0; i < cardCount; i++) {
               if (user.getCard(i).getRank() != user.getTripsNum()) {
                  userCardNum = user.getCard(i).getRank();
                  user2CardNum = user2.getCard(i).getRank();
               }
            }
            if (userCardNum > user2CardNum) {
               return user;
            } else {
               return user2;
            }
         } else {
            return user2;
         }
      }
      return null;
   }

   public void checkWinner() {
      winner = new User();
      for (int i = 0; i < userCount; i++) {
         for (int j = 0; j < cardCount; j++) {
            System.out.println("유저의 패: " + user[i].getCard(j).getRank());
         }
         System.out.println("------------");
      }
      System.out.println("위나  " + winner.getPoint());
      //
      checkPair();
      checkFlush();
      checkPoint();
      // 포인트 같을 경우 : pair >> rank로 비교, flush, straight >> shape로 비교.
      for (int i = 0; i < userCount; i++) {
         if (user[i].getPoint() > winner.getPoint()) {
            winner = user[i];
         } else if (user[i].getPoint() == winner.getPoint()) {
            if (user[i].getPoint() == 6 || user[i].getPoint() == 9 || user[i].getPoint() == 10) {
               winner = compareShape(user[i], winner);
            } else {
               winner = comepareRank(user[i], winner);
            }
         }
      }
      // System.out.println("승자 " + winner.getCard(4).getRank());
   }
}