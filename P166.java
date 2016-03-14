import java.util.HashMap;
import java.util.Map;

public class P166 {
    public String fractionToDecimal(int numerator, int denominator) {
    	if(numerator==0) return "0";
    	if(denominator==1) return numerator+"";
    	else if(denominator==-1) {
    		String res = numerator+"";
    		if(numerator<0) return res.substring(1);
    		else return "-"+res;
    	}
    	if((numerator<0&&denominator>=0)) 
    		return "-"+fractionToDecimal(numerator, -denominator);
    	else if(numerator>=0&&denominator<0)
    		return "-"+fractionToDecimal(-numerator, denominator);
        long part = ((long)numerator)/denominator;
        long last = ((long)numerator)%denominator;
		StringBuilder res = new StringBuilder();
		res.append(part);
		if(last==0) return res.toString();
		Map<Long, Long> memo = new HashMap<>();
		String part2 = ".";
		long index = 0;
		last *= 10;
		while(last != 0) {
			if(memo.containsKey(last)) {
				return res+part2.substring(0, (int) (memo.get(last)+1))+"("+part2.substring((int) (memo.get(last)+1))+")";
			}
			else {
				memo.put(last, index++);
				part2+= last/denominator;
				last %= denominator;
				last *= 10;
			}
		}
		return res+part2;
    }
}