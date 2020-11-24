package dieHard;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Divide {
	public static double quotient(double nume, double deno) throws ArithmeticException {
		return nume / deno;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean loop = true;

		do {
			try {
				System.out.print("Please enter an integer nume : ");
				int numerator = input.nextInt();
				System.out.print("Please enter an integer deno : ");
				int denominator = input.nextInt();
				if (numerator == -1 && denominator == 0) {
					System.out.println("프로그램을 종료합니다!");
					loop = false;
					break;
				}
				double result = quotient(numerator, denominator);
				System.out.printf("\nResult: %d / %d = %.3f\n", numerator, denominator, result);
			} catch (InputMismatchException inputMismatchException) {
				System.err.printf("\nException: %s\n", inputMismatchException);
				input.nextLine();
				System.out.println("You must enter integers. Please try again.\n");
			} catch (ArithmeticException arithmeticException) {
				System.err.printf("\nException: %s\n", arithmeticException);
				System.out.println("Zero is an invalid denominator. Please try again.\n");
			} finally {
			}
		} while (loop);
	}
}
