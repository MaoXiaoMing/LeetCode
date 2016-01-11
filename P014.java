
public class P014 {

	public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0) return "";
        int minLength = Integer.MAX_VALUE;
        int index = 0;
        for(int i=0; i<strs.length; i++) {
        	if((strs[i]==null)||strs[i].equals("")) {
        		return "";
        	}
        	if(minLength > strs[i].length()) {
        		minLength = strs[i].length();
        		index = i;
        	}
        }
		for(int i=0; i<minLength; i++) {
			char c = strs[index].charAt(i);
			for(int j=0; j<strs.length; j++) {
				if(strs[j].charAt(i) != c) {
					if(i==0) {
						return "";
					}else {
						return strs[index].substring(0, i);
					}
				}
			}
		}
		return strs[0].substring(0, minLength);
    }
	
	public static void main(String[] args) {
		"123".substring(0, 0);
	}

}
