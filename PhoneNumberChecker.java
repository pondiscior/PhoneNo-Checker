package com.collabera.phonechecker;

import java.util.Scanner;

public class PhoneNumberChecker {
		/* The only formats accepted are
		 - 0000000000
		 - 000-000-0000
		 - (000)000-0000
		 As of now, non-number characters are accepted as valid if formating is correct and 911 does
		 not exist in the string.
		 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String inputnew = "";
		boolean stillrunning = true;
		do {
			boolean wrong = false;
			System.out.println("Please enter a valid phone number:");
			String input = sc.nextLine();
			if (input.length() == 10) {
				for (int i = 0; i < input.length(); i++) {
					if (input.charAt(i) == '9' && input.charAt(i + 1) == '1' && input.charAt(i + 2) == '1') {
						wrong = true;
					}
				}
				if (wrong) {
					System.out.println("Number cannot contain '911' in it");
				} else {
					stillrunning = false;
				}
			}
			if (input.length() == 12) {
				if (input.charAt(3) == '-' && input.charAt(7) == '-') {
					inputnew = input.replace("-", "");
					for (int i = 0; i < inputnew.length(); i++) {
						if (inputnew.charAt(i) == '9' && inputnew.charAt(i + 1) == '1' && inputnew.charAt(i + 2) == '1') {
							wrong = true;
						}
					}
					if (wrong) {
						System.out.println("Number cannot contain '911' in it");
					} else {
						stillrunning = false;
					}
				} else {
					System.out.println("Dashes not correctly inputed");
				}

			}
			if (input.length() == 13) {
				if (input.charAt(0) == '(' && input.charAt(4) == ')' && input.charAt(8) == '-') {
					inputnew = input.replace("(", "");
					inputnew = inputnew.replace(")", "");
					inputnew = inputnew.replace("-", "");
					for (int i = 0; i < inputnew.length(); i++) {
						if (inputnew.charAt(i) == '9' && inputnew.charAt(i + 1) == '1' && inputnew.charAt(i + 2) == '1') {
							wrong = true;
						}
					}
					if (wrong) {
						System.out.println("Number cannot contain '911' in it");
					} else {
						stillrunning = false;
					}
				} else {
					System.out.println("Parentheses or dashes not correctly inputed");
				}
			}
		} while (stillrunning);
		System.out.println("Valid number inputed!");
		sc.close();
	}

}
