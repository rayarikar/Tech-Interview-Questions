import java.util.*;

/*
Given a binary search tree in an array form constructed as an inorder traversal, return true
if the element is present in the array else return false

e.g. 	searchTree(10, [5,10,20]) ==> true
	searchTree(80, [5,10,20]) ==> false
*/
class BST {
	static boolean searchBST(List<Integer> input, int elem, int start, int end)
	{
		int mid = (start + end) / 2;
		if (start > end)
			return false;
		else if (input.get(mid) == elem)
			return true;
		else if (elem > input.get(mid))
			return searchBST(input, elem, mid+1, end);
		else if (elem < input.get(mid))
			return searchBST(input, elem, 0, mid-1);
		return false;
	}

	public static void main(String[] args)
	{
		List<Integer> input = new ArrayList<Integer>();
		for (String arg : args)
		{
			input.add(Integer.parseInt(arg));
		}
		System.out.println("\nInput BST: ");
		int elem = 0;
		for (int i = 0; i < input.size(); i++)
		{
			if (i == input.size() - 1)
				elem = input.get(i);
			else
				System.out.print(input.get(i) + " ");
		}
		System.out.println("\nElement to search: " + elem + "\n");
		if (searchBST(input, elem, 0, input.size() - 2))
			System.out.println(elem + " is a valid node in BST");
		else
			System.out.println("Oops!! " + elem + " does not exist in BST");
	}
}
