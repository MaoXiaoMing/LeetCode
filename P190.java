
/*
 * Reverse Bits
 * Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?*/

public class P190 {
	public static int reverseBits(int n) {
        int count = 32;
        int res = 0;
        while(count > 0) {
        	int last = n&1;
        	n >>= 1;
        	res = (res<<=1)+last;
        	count--;
        }
        return res;
    }
	
	public static void main(String[] args) {
		System.out.println(reverseBits(43261596));
	}
}
