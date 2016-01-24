
public class P115 {
	
    public int numDistinct(String s, String t) {
    	if(t.length()==0) return 1;
    	else if(s.length()<t.length()) return 0;
    	int[][] memo = new int[s.length()][t.length()];
    	int count = 0;
    	for(int i=0; i<s.length(); i++) {
    		if(s.charAt(i)==t.charAt(0))
    			memo[i][0] = ++count;
    		else 
    			memo[i][0] = count;
    	}
    	for(int indexT=1; indexT<t.length(); indexT++) {
    		for(int indexS=indexT; indexS<s.length(); indexS++) {
    			memo[indexS][indexT] += memo[indexS-1][indexT];
    			if(s.charAt(indexS)==t.charAt(indexT)) 
    				memo[indexS][indexT]+=memo[indexS-1][indexT-1];
    		}
    	}
    	return memo[s.length()-1][t.length()-1];
//        return numDistinct(s, 0, t, 0);
    }
    
    public int numDistinct(String s, int indexS, String t, int indexT) {
    	if(t.length()-indexT > s.length()-indexS) return 0;
    	if(indexT==t.length()) return 1;
    	int result = 0;
    	if(s.charAt(indexS)==t.charAt(indexT)) 
    		result += numDistinct(s, indexS+1, t, indexT+1);
    	result += numDistinct(s, indexS+1, t, indexT);
    	return result;
    }
    
    
	public static void main(String[] args) {
		P115 test = new P115();
		System.out.println(test.numDistinct("a","ab"));
	}

}
