
public class P010 {
	
    public boolean isMatch(String s, String p) {
        return recursion(s, p, 0, 0);
    }
    
    public boolean recursion(String s, String p, int index1, int index2) {
    	if(index2==p.length()) return index1==s.length();
    	if(index2==p.length()-1) {
    		if(index1==s.length()-1 && 
    				(s.charAt(index1)==p.charAt(index2) || p.charAt(index2)=='.'))
    			return true;
    		else return false;
    	}else {
    		if(p.charAt(index2+1)!='*') {
    			if(index1<s.length() && (s.charAt(index1)==p.charAt(index2) || p.charAt(index2)=='.')) 
    				return recursion(s, p, index1+1, index2+1);
    			else return false;
    		}else {
    			while(index1<s.length() && (s.charAt(index1)==p.charAt(index2) || p.charAt(index2)=='.')) {
    				if(recursion(s, p, index1, index2+2)) 
    					return true;
    				index1++;
    			}
    			return recursion(s, p, index1, index2+2);
    		}
    	}
//		看都懒得看
//    	if(index1==s.length()) return index2==p.length();
//    	if(index2==p.length()-1) {
//    		if(index1==s.length()-1 &&
//    				(p.charAt(index2)=='.' || p.charAt(index2)==s.charAt(index1))) {
//    			return true;
//    		}else return false;
//    	}else {
//    		if(p.charAt(index2+1) != '*') {
//    			if(p.charAt(index2)==s.charAt(index1) || p.charAt(index2)=='.') {
//    				return recursion(s, p, index1+1, index2+1);
//    			}else return false;
//    		}else {
//    			while(s.charAt(index1)==p.charAt(index2) 
//    					|| (p.charAt(index2)=='.')) {
//    				if(recursion(s, p, index1, index2+2)) return true;
//    				index1++;
//    			}
//    			return recursion(s, p, index1, index2+2);
//    		}
//    	}
    }
    
	public static void main(String[] args) {
		P010 p = new P010();
		System.out.println(p.isMatch("a", "a"));
	}

}
