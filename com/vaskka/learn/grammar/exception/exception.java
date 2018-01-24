/*
javac encoding utf-8 com/vaskka/learn/grammar/exception/exception.java
java com/vaskka/learn/grammar/exception/Program
*/

package com.vaskka.learn.grammar.exception;

import java.util.Scanner;

class NotALetterException extends Exception {
	@Override
	public String toString() {
		return "com.vaskka.learn.grammar.exception.NotALetterException: 第一个字符不是英文";
	}
}


class Program {
	public static String change(String s) throws NullPointerException, NotALetterException {
		if (s == null) {
			throw new NullPointerException("传入的参数为空");
		}

		Character first = s.charAt(0);
		if (!((first >= 65 && first <= 90) || (first >= 97 && first <= 122))) {
			throw new NotALetterException();
		}

		String left = s.substring(1);
		return first.toString().toUpperCase() + left;
	}


	public static void main(String[] argc) {
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		try {
			String result = change(s);
			System.out.println(result);
		}
		catch (NullPointerException e) {
			System.out.println(e.toString());
		}
		catch (NotALetterException e) {
			//System.out.println(e.toString());
			e.printStackTrace();
				
		}

	}


}