package general;

import java.util.HashSet;
import java.util.Set;

public class Permutation {
	
	public static void main(String args[]) {
		Set<String> set = new HashSet<String>();
		
//        permutationChar(new char[3], "GOD".toCharArray(),set,0);
        
		permutation("","GOD",set);
		
        for(String s:set) {
        	System.out.println(s);
        }
        
    }

	
	
	
/*	   private static void permutationChar(char[] perm, char [] word,Set<String> set,int index) {
	        if (word.length<=index) {
	            set.add(new String(perm));
	        } else {
	            for (int i = index; i < word.length; i++) {
	            	char c  = word[i];
	            	word[i] = word[index];
	            	word[index] = c;
	            	perm[i] = c;
	                permutationChar(perm,word,set,index+1);
	            }
	        }

	    }
	*/
	
	   private static void permutation2(String perm, String word,Set<String> set) {
	        if (word.isEmpty()) {
	            set.add(perm);
	        } else {
	            for (int i = 0; i < word.length(); i++) {
	            	char [] s = word.toCharArray();
	            	char c  = s[i];
	            	s[i] = s[0];
	            	s[0] = c;
	            	
	            	//permutation(perm + c, s.word.substring(1, word.length()),set);
	            	
	                permutation(perm + word.charAt(i), 
	                		word.substring(0, i) 
	                                        + word.substring(i + 1, word.length()),set);
	            }
	        }

	    }
	
   private static void permutation(String perm, String word,Set<String> set) {
        if (word.isEmpty()) {
            set.add(perm);
        } else {
            for (int i = 0; i < word.length(); i++) {
            	//permutation(perm + c, s.word.substring(1, word.length()),set);
            	
                permutation(perm + word.charAt(i), 
                		word.substring(0, i) 
                                        + word.substring(i + 1, word.length()),set);
            }
        }

    }
	
	
	
	

}
