package Tests;
import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ActOnUtils.*;

public class StringPermutationsTests  {

	@Test
	public void PrintUniqueStringPermutations_UniqueReturnedValues() {
		String[] arr = StringPermutations.PrintUniqueStringPermutations("abc");
		ArrayList<String> lst = new ArrayList<String>();
		
		lst.add("acb");
		lst.add("bca");
		lst.add("abc");
		lst.add("cba");
		lst.add("bac");
		lst.add("cab");
		
		for (String s : arr) 
			lst.remove(s);
		
		if (lst.size() != 0)
			Assert.fail();
	}
	
	@Test
	public void PrintUniqueStringPermutations_EmptyString() {
		String[] arr = StringPermutations.PrintUniqueStringPermutations("");
		String[] expectedArr = new String[] {""};
		assertArrayEquals(expectedArr, arr);
	}
	
	@Test
	public void PrintUniqueStringPermutations_Null() {
		String[] arr = StringPermutations.PrintUniqueStringPermutations(null);
		assertArrayEquals(arr, new String[0]);
	}
	
	@Test
	public void PrintUniqueStringPermutations_UniqueChars() {
		String[] arr = StringPermutations.PrintUniqueStringPermutations("abc");
		HashSet<String> set = new HashSet<String>();
		CheckForDuplicates(arr, set);
	}
	
	@Test
	public void PrintUniqueStringPermutations_DuplicateChars() {
		String[] arr = StringPermutations.PrintUniqueStringPermutations("Yolo");
		HashSet<String> set = new HashSet<String>();
		CheckForDuplicates(arr, set);							
	}	
	
	@Test
	public void PrintUniqueStringPermutations_ResultsLength() {
		String input = "abc";
		String[] arr = StringPermutations.PrintUniqueStringPermutations(input);
		
		for(String s : arr) 
			if (s.length() != input.length())
				Assert.fail();
	}
	
	@Test
	public void PrintUniqueStringPermutations_UpperAndLowerCaseLetters() {
		String[] arr = StringPermutations.PrintUniqueStringPermutations("Mom");
		HashSet<String> set = new HashSet<String>();	
		CheckForDuplicates(arr, set);	
	}
	
	@Test
	public void PrintUniqueStringPermutations_Spaces() {
		String[] arr = StringPermutations.PrintUniqueStringPermutations("   ");
		HashSet<String> set = new HashSet<String>();	
		CheckForDuplicates(arr, set);	
	}
	
	@Test
	public void PrintUniqueStringPermutations_Symbols() {
		String[] arr = StringPermutations.PrintUniqueStringPermutations("!@#$%d");
		HashSet<String> set = new HashSet<String>();	
		CheckForDuplicates(arr, set);	
	}
	
	private void CheckForDuplicates(String[] arr, HashSet<String> set){	
		for(String s : arr) {
			if (set.contains(s))
				Assert.fail();
			else
				set.add(s);
		}	
	}
	
}
