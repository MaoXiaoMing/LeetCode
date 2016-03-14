public class P091 {
    public int numDecodings(String s) {
        int length = s.length();
		char[] chars  = s.toCharArray();
		if(length == 0) return 0;
		if(length ==1) {
			if(chars[0]=='0') return 0;
			else return 1;
		}
		int first = chars[0]=='0'?0:1;
		int num = (chars[0]-'0')*10+chars[1]-'0';
		int second = 0;
		if(num==10||num==20||(num>=27&&(num%10!=0))) second = 1;
		else if(num>=11 && num<=26) second = 2;
		else second = 0;
		int res = second;
		for(int i=2; i<length; i++) {
			num = (chars[i-1]-'0')*10+chars[i]-'0';
			if((num/10>2 && num%10==0) || num==0) return 0;
			if(num>=11&&num<=26&&num!=20) {
				res = first+second;
			}else if(num>=27 || (num>0&&num<10)){
				res = second;
			}else {
				res = first;
			}
			first = second;
			second = res;
		}
		return res;
    }
}