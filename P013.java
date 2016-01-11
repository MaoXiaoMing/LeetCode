import java.util.HashMap;
import java.util.Map;

/*
 * Roman to Integer
 * Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.*/
public class P013 {

	public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('X', 10);
        map.put('C', 100);
        map.put('M', 1000);
        map.put('V', 5);
        map.put('L', 50);
        map.put('D', 500);
        if(s==null || s.equals("")) return 0;
        int result = map.get(s.charAt(0));
        for(int i=1; i<s.length(); i++) {
        	if((s.charAt(i-1)=='I'||s.charAt(i-1)=='X'||s.charAt(i-1)=='C')
        			&& (map.get(s.charAt(i-1))<map.get(s.charAt(i))))
        	{
        		result += (map.get(s.charAt(i))-2*map.get(s.charAt(i-1)));
        	}else {
        		result += map.get(s.charAt(i));
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		romanToInt("MCMXCVI");
	}

}
