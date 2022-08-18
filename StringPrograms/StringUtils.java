package strings;

import java.util.Arrays;

public class StringUtils {

	public static void main(String[] args) {
		StringUtils su = new StringUtils();

		su.reverseString("iNeuron");

		su.reverseEachStringInSentence("Think Twice");

		su.sortAlphabetically("reweDFGGGethu govind");

		su.getCountOfSpecChars("DSFSVV  22 @#D");

		su.printCountOfConsAndVow("hyfgyu  6544uioiyhgc");

		su.isPangram("The quick brown fox jumps over the lazy dog");

		su.isAnagram("Tarts","ttars");

		su.printRepeatingChars("sdfretrrghh223!!!gfg..");
	}

		private String reverseString(String input) {
		String revInput = "";
		for (int i = input.length() - 1; i >= 0; i--) {
			revInput = revInput + input.charAt(i);
		}
		System.out.println("The reversed string is : "+revInput);
		return revInput;
	}

	private String reverseEachStringInSentence(String input) {
		String revInput = "";
		String[] strings = input.split(" ");
		for (String s : strings) {
			for (int i = s.length() - 1; i >= 0; i--) {
				revInput = revInput + s.charAt(i);
			}
			revInput += " ";
		}
		System.out.println("The reversed string is : "+revInput);
		return revInput;
	}

	private boolean isAnagram(String input1,String input2) {
		boolean isAnagram = false;
		if(this.sortAlphabetically(input1.toUpperCase()) .equals( this.sortAlphabetically(input2.toUpperCase())) ) {
			isAnagram  = true;
			System.out.println("The given string is an anagram");
		}else {
			System.out.println("The given string is not an anagram");
		}
		return isAnagram;
	}

	private boolean isPangram(String input) {
		boolean isPangram = false;
		char[] alphabets = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
				'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		String newInput = input.toUpperCase();
		int count = 0;
		for (char c : alphabets) {
			if (newInput.indexOf(c) > -1) {
				count++;
			}
		}
		if (count == alphabets.length) {
			isPangram = true;
			System.out.println("The given string is an pangram");
		}else {
			System.out.println("The given string is not an pangram");			
		}
		return isPangram;
	}

	private String sortAlphabetically(String input) {
		String sortedInput = "";
		char[] charArray = input.toCharArray();
		// Arrays.sort(charArray);
		for (int i = 0; i < charArray.length; i++) {
			for (int j = i + 1; j < charArray.length; j++) {
				if (charArray[i] > charArray[j]) {
					char temp = charArray[i];
					charArray[i] = charArray[j];
					charArray[j] = temp;
				}
			}
			sortedInput = new String(charArray);
		}
		System.out.println("The sorted string is : "+sortedInput);
		return sortedInput;
	}

	private void printCountOfConsAndVow(String input) {
		int consCount = 0, vowCount = 0;
		for (int i = input.length() - 1; i >= 0; i--) {
			if ((input.charAt(i) <= 'z' && input.charAt(i) >= 'a')
					|| (input.charAt(i) <= 'Z' && input.charAt(i) >= 'A'))
				if (input.charAt(i) == 'a' || input.charAt(i) == 'e' || input.charAt(i) == 'i' || input.charAt(i) == 'o'
						|| input.charAt(i) == 'u' || input.charAt(i) == 'A' || input.charAt(i) == 'E'
						|| input.charAt(i) == 'I' || input.charAt(i) == 'O' || input.charAt(i) == 'U') {
					vowCount++;
				} else {
					consCount++;
				}
		}
		System.out.println("Number of Consonants are:  " + consCount);
		System.out.println("Number of Vowels are:  " + vowCount);
	}

	private int getCountOfSpecChars(String input) {
		int count = 0;
		for (int i = input.length() - 1; i >= 0; i--) {
			if (!((input.charAt(i) <= 'z' && input.charAt(i) >= 'a')
					|| (input.charAt(i) <= 'Z' && input.charAt(i) >= 'A')
					|| (input.charAt(i) <= '9' && input.charAt(i) >= '0')))
				count++;
		}
		System.out.println("The no of special characters are : "+count);
		return count;
	}

	private void printRepeatingChars(String input) {
		char[] charArray = input.toCharArray();
		String repChars = "";
		for (int i = 0; i < charArray.length; i++) {
			for (int j = i + 1; j < charArray.length; j++) {
				if (charArray[i] == charArray[j] && repChars.indexOf(charArray[i]) < 0) {
					repChars += charArray[i];
					break;
				}
			}
		}
		System.out.println("The repeating characters are : "+Arrays.toString(repChars.toCharArray()));

	}

}
