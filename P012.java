
/*
 * 12. Integer to Roman
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
*/
public class P012 {
    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
    	int th = num/1000;
    	int count = th;
    	while(count>0) {
    		res.append("M");
    		count --;
    	}
    	int hu = (num-th*1000)/100;
    	if(hu<=3) {
    		count = hu;
    		while(count>0) {
    			res.append("C");
    			count --;
    		}
    	}else if(hu==4) {
    		res.append("CD");
    	}else if(hu<=8){
    		res.append("D");
    		count = hu - 5;
    		while(count > 0) {
    			res.append("C");
    			count--;
    		}
    	}else {
    		res.append("CM");
    	}
    	int te = (num-1000*th-100*hu)/10;
    	if(te<=3) {
    		count = te;
    		while(count>0) {
    			res.append("X");
    			count --;
    		}
    	}else if(te==4) {
    		res.append("XL");
    	}else if(te<=8){
    		res.append("L");
    		count = te - 5;
    		while(count > 0) {
    			res.append("X");
    			count--;
    		}
    	}else {
    		res.append("XC");
    	}
    	int on = num%10;
    	if(on <= 3) {
    		count = on;
    		while(count>0) {
    			res.append("I");
    			count --;
    		}
    	}else if(on==4) {
    		res.append("IV");
    	}else if(on<=8){
    		res.append("V");
    		count = on - 5;
    		while(count > 0) {
    			res.append("I");
    			count--;
    		}
    	}else {
    		res.append("IX");
    	}
    	return res.toString();
    }
}
