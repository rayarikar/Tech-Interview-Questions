import java.util.*;

/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000
*/
class PalindroneSubstring {

	static PalindroneSubstring obj;
	Map<Integer, String> palinMap = new HashMap<Integer, String>();	
	int originalInputLength = 0;

	public void checkForPalindrone(String input)
	{
		if (input == null || input.length() == 0)
		{
			System.out.println("INVALID STRING");
			return;
		}
		else 
		{
			originalInputLength = input.length();
			getLongestPalindromeSubString(input);
			if (palinMap.size() == 0)
			{
				System.out.println("OOPS!! No palindrome substrings");
			}
			else
			{
				System.out.println("\nPalindrome substrings in length : Substring format:");
				for (int keyLength : palinMap.keySet())
				{
					if (keyLength >= input.length())
						continue;
					System.out.println(keyLength + " : " + palinMap.get(keyLength));
				}
			} 
		}
		System.out.println();
	}

	public void getLongestPalindromeSubString(String input)
	{
		if (obj.isPalindrone(input) && input.length() < originalInputLength)
		{
			obj.addToMap(input);
		}
		else 
		{
			getLongestPalindromeSubString(input.substring(1));	
			getLongestPalindromeSubString(input.substring(0, input.length() - 1));
			getLongestPalindromeSubString(input.substring(1, input.length() - 1));
		}
	}
	
	public boolean isPalindrone(String inputString)
	{	
		StringBuilder input = new StringBuilder(inputString);
		if (input.toString().equalsIgnoreCase(input.reverse().toString()))
			return true;
		return false;	
	}

	public void addToMap(String input)
	{
		if (!palinMap.containsKey(input) && input.length() > 1)
		{
			palinMap.put(input.length(), input);
		}
	}

	public static void main(String[] args)
	{
		System.out.println("\nInput String: " + args[0]);
		obj = new PalindroneSubstring();
		obj.checkForPalindrone(args[0]);
	}
}
