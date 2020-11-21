package Cardgame;

import java.util.*;

public class Main {
	private static ArrayList<String> poker = new ArrayList<String>();
//	private static RanCard RC = new RanCard();

	private static Scanner input = new Scanner(System.in);
	public static int count = 0;

	public static void main(String[] args) {
		while (true) {
			count++;
			for (int i = 0; i < 5; i++) {
				poker.add(RanCard.getCard());
			}

			System.out.println("게임 " + count + " : " + poker + " " + RanCard.sameCard());
			System.out.println("진행 : 0, 종료 : 1");

			int in = input.nextInt();
			if (in == 1) {
				break;
			}
			for (int i = 0; i < 5; i++)
				poker.remove(0);

		}

	}
}
