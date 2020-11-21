package pokerGame;

import java.util.Arrays;
import java.util.Random;

public class Deck {
   private Card[] deck52 = new Card[52];
   private static final Random random = new Random();
   private String[] shape = { "♣", "♥", "♠", "◆" };
   private int[] ranks = { 14, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 }; // userDeck = { A 1 2 3 4 } 인 경우 : A = 1

   public Deck() {
      for (int i = 0; i < deck52.length; i++) { // 카드 shuffle.
         int pickShape = i / 13;
         int pickRanks = i % 13;
         deck52[i] = new Card(shape[pickShape], ranks[pickRanks]);
      }
   }

   public void pushCard(User user) { // user에게 카드 나눠줌.
      Card[] tempDeck = new Card[Game.cardCount];
      for (int j = 0; j < Game.cardCount; j++) {
         int pick = random.nextInt(52);
         if (deck52[pick] != null) {
            tempDeck[j] = new Card(deck52[pick].getShape(), deck52[pick].getRank());
            deck52[pick] = null;
         } else {
            j--;
         }
      }
      Card[] userDeck = new Card[Game.cardCount];
      sortDeck(tempDeck, userDeck);
      user.setDeck(userDeck);
   }

   public void sortDeck(Card[] tempDeck, Card[] userDeck) {
      int[] ranks = new int[Game.cardCount];

      for (int i = 0; i < Game.cardCount; i++) {
         ranks[i] = tempDeck[i].getRank();
      }

      Arrays.sort(ranks);

      for (int i = 0; i < Game.cardCount; i++) {
         for (int j = 0; j < Game.cardCount; j++) {
            if (tempDeck[j] != null) {
               if (tempDeck[j].getRank() == ranks[i]) {
                  userDeck[i] = new Card(tempDeck[j].getShape(), tempDeck[j].getRank());
                  tempDeck[j] = null;
                  break;
               }
            }
         }
      }
   }
}