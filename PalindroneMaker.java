import java.util.*;

/*
Given a string, add some characters to the front of it so that it becomes a shortest possible palindrome. E.g.1) If input is "abc" then "bcabc" should be returned. 2) input -> "ab" output -> "bab" 3) input -> "a" output -> "a"
*/
class PalindroneMaker {
	
	public String makePalindrone(String input)
	{
		String palindrone = "";
		// if the string is palindrone, just return that
		if ((new PalindroneMaker()).isPalindrone(new StringBuilder(input)))
		{
			palindrone = input;
		}
		else
		{
			StringBuilder toAddBuffer = new StringBuilder();
			for (int i = input.length() - 1; i >= 0; i--)
			{
				toAddBuffer.append(input.charAt(i));
				if (isPalindrone(new StringBuilder(input.substring(0, i))))
					break;
			}
			// we already have the toAddBuffer which makes the string a non-palindrone. now reverse and add this in the begining
			System.out.println("Buffer to add in the begining: " + toAddBuffer.toString() + "\n");
			String prependString = toAddBuffer.toString();
			palindrone = prependString + input; 	
		}
		return palindrone;
	}
	
	public boolean isPalindrone(StringBuilder input)
	{
		if (input.toString().equalsIgnoreCase(input.reverse().toString()))
			return true;
		return false;	
	}

	public static void main(String[] args)
	{
		System.out.println("\nInput String: " + args[0]);
		PalindroneMaker obj = new PalindroneMaker();
		String palindrone = obj.makePalindrone(args[0]);
		System.out.println("\nPalindrone String: " + palindrone + "\n");
	}
}
