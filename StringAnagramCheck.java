import java.util.*;

class StringAnagramCheck {
	public static void main(String args[])
	{
		String str1 = args[0];
		String str2 = args[1];
		System.out.println("First word is: " + str1);
		System.out.println("Second word is: " + str2);
		if (str1.length() != str2.length()) 
		{
			System.out.println("Not anagrams");
		}		
		else
		{
			Map<Character,Integer> wcMap = new HashMap<Character,Integer>();
			// st1 populates map
			for (char c : str1.toCharArray())
			{
				if (wcMap.containsKey(c))
				{
					int cCount = wcMap.get(c);
					wcMap.put(c, cCount+1);
				}
				else
				{
					wcMap.put(c, 1);
				}
			}
			// str2 decrements the numbers
			for (char c : str2.toCharArray())
			{
				if (wcMap.containsKey(c))
                                {
                                        int cCount = wcMap.get(c);
                                        wcMap.put(c, cCount-1);
                                }
                                else
                                {
                                        System.out.println("Not anagrams");
					System.exit(1);
                                }
			}
			// loop over the hashmap to ensure there are no keys with non 0 char count
			for (char key : wcMap.keySet())
			{
				if (wcMap.get(key) > 0)
				{
					System.out.println("Not anagrams");
                                        System.exit(1);
				}
			}
			System.out.println("Anagrams!!");
		}
	}
}
