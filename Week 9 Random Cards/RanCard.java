package Cardgame;

import java.util.ArrayList;
import java.util.Random;

public class RanCard {
	private static Random randomNumbers = new Random();
	private static ArrayList<String> numTemp = new ArrayList<String>();
	private static ArrayList<String> numV = new ArrayList<String>();
	private static int cNum, dNum;

	static final String[] card = { "C", "D", "H", "S" };
	static final String[] num = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13" };

	public static String getCard() {
		String temp;
		cNum = randomNumbers.nextInt(4);
		dNum = randomNumbers.nextInt(13);
		numV.add(num[dNum]);
		numTemp.add(card[cNum] + num[dNum]);
		temp = card[cNum] + num[dNum];
		
		return temp;
	}

	public static String sameCard() {
		boolean flag = false;
		String tSame = null;
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 5; j++) {
				if (numV.get(i) == numV.get(j)) {
					if (tSame == null) {
						tSame = numV.get(i);
						flag = true;
						// count++;
					} else if (Integer.parseInt(tSame) < Integer.parseInt(numV.get(i))) {
						tSame = numV.get(i);
					}
				}
			}
		}
		if (!flag) {
			tSame = "Dealer Wins";
		} else {
			tSame = tSame + " pair. Player wins";
		}
		for (int i = 0; i < 5; i++)
			numV.remove(0);

		return tSame;
	}

	/*
	 * public static int getNum() { int tNum; dNum = randomNumbers.nextInt(13);
	 * numV.add(num[dNum]); tNum = Integer.parseInt(num[dNum]);
	 * 
	 * return tNum; }
	 */
}
