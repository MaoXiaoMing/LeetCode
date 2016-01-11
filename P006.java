
/*ZigZag Conversion
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

public class P006 {
	public static String convert(String s, int numRows) {
		if(numRows <= 1) return s;
		StringBuilder sb = new StringBuilder();
		int row = 0;
		int gap = (numRows-1)*2;
		while(row < numRows) {
			for(int i=0; i<s.length(); i++) {
				if(i%gap==row || i%gap==(gap-row)) sb.append(s.charAt(i));
			}
			row++;
		}
		return sb.toString();
/*	    if(numRows == 1) return s;
	    int gap = (numRows-1)<<1;
	    StringBuilder result = new StringBuilder();
	    for(int i=0; i<numRows; i++) {
	        int current = i;
	        int offset = gap - (i<<1);
	        while(current<s.length()) {
	            if( offset != 0 ) { 
	                // avoid inserting duplicate elements
	                // in the first and the last row
	                result.append(s.charAt(current));

	                current += offset;
	            }
	            offset = gap-offset;
	        }
	    }

	    return result.toString();		
*/
		/*if(numRows == 1) return s;
		StringBuilder sb = new StringBuilder();
		int gap = (numRows-1)*2;
		for(int i=0; i<s.length(); i+=gap) {
			sb.append(s.charAt(i));
		}
        for(int i=1; i<numRows-1; i++) {
        	for(int j=i; j<s.length(); j+=(numRows-1)) {
        		sb.append(s.charAt(j));
        	
        }
        for(int i=numRows-1; i<s.length(); i+=gap) {
        	sb.append(s.charAt(i));
        }
        return sb.toString();*/
//		if(numRows<=1) return s;
//	    StringBuilder sb = new StringBuilder();
//	    int num = 2*numRows - 2; 
//	    int mod = 0;
//	    while(mod<numRows) {
//	        for(int i=0; i<s.length(); i++) {
//	            if(i%num==mod || i%num==(num-mod)) {
//	                sb.append(s.charAt(i));
//	            }
//	        }
//	        mod++;
//	    }
//	    return sb.toString();
    }
	
	public static void main(String[] args) {
		System.out.println(convert("ABCDE", 4));
	}

}
