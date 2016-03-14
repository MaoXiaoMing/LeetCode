import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*187. Repeated DNA Sequences
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].*/

public class P187 {
	
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> res = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<=s.length()-10; i++) {
        	String str = s.substring(i, i+10);
        	if(!map.containsKey(str)) map.put(str, 1);
        	else res.add(str);
        }
        return new ArrayList<>(res);
    }
}
