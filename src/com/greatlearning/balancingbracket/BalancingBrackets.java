package com.greatlearning.balancingbracket;

import java.util.Scanner;
import java.util.Stack;

public class BalancingBrackets {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Please input the bracket string");

		String brackets = sc.nextLine();

		Boolean result = false;

		result = checkBalancedBracket(brackets);

		if (result)
			System.out.println("The entered String has Balanced Brackets");
		else
			System.out.println("The entered Strings do not contain Balanced Brackets");

		sc.close();

	}

	private static Boolean checkBalancedBracket(String brackets) {

		Stack<Character> balanceStack = new Stack<>();

		for (int i = 0; i < brackets.length(); i++) {
			
			char character = brackets.charAt(i);

			if (character == '(' || character == '{' || character == '[') {
				balanceStack.push(character);
				continue;
			}

			if (balanceStack.isEmpty())
				return false;

			char c;

			switch (character) {

			case '}':
				c = balanceStack.pop();
				if (c == '(' || c == '[')
					return false;
				break;

			case ')':
				c = balanceStack.pop();
				if (c == '{' || c == '[')
					return false;
				break;

			case ']':
				c = balanceStack.pop();
				if (c == '{' || c == '(')
					return false;
				break;
			}
		}

		return (balanceStack.isEmpty());
	}

}
