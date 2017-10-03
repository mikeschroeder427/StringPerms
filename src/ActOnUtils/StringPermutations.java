package ActOnUtils;
import java.util.HashSet;
import java.util.Set;

public class StringPermutations {

	public static void main(String args[]) {
		if (args.length > 0) 
			PrintUniqueStringPermutations(args[0]);	
	}

	public static String[] PrintUniqueStringPermutations(String input) {
		Set<String> set = new HashSet<String>();
		String[] arr = GenString("", input, set);
		
		for(String s: arr)
			System.out.println(s);
		
		return arr;
	}
	
	private static String[] GenString(String start, String input, Set<String> set) {
        if(input.length() == 0) {
        	if (!set.contains(start)) {
        		set.add(start);
        	}
        }
        else {
            for (int i = 0; i < input.length(); i++)
            	GenString(start + input.charAt(i), input.substring(0, i) + input.substring(i + 1, input.length()), set);
        }
    	return set.toArray(new String[set.size()]);
	}

}