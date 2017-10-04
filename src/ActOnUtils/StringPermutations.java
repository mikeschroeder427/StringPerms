package ActOnUtils;
import java.util.HashSet;
import java.util.Set;

public class StringPermutations {
	
	public static void main(String args[]) {		
		if (args.length > 0) 
			PrintUniqueStringPermutations(args[0]);	
	}

	public static String[] PrintUniqueStringPermutations(String input) {
		
		if (input == null)
			return new String[0];
		
		String[] arr = GenUniqueStrings("", input.toLowerCase(), new HashSet<String>());
		
		for(String s: arr)
			System.out.println(s);
				
		return arr;
	}
	
	private static String[] GenUniqueStrings(String start, String input, HashSet<String> set) {
        if(input.length() == 0) {
        	set.add(start);      	
        }
        else {
            for (int i = 0; i < input.length(); i++)
            	GenUniqueStrings(start + input.charAt(i), input.substring(0, i) + input.substring(i + 1, input.length()), set);
        }
    	return set.toArray(new String[set.size()]);
	}

}