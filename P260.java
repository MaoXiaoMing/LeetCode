import java.util.ArrayList;
import java.util.List;

public class P260 {
    public int[] singleNumber(int[] nums) {
		int[] bits = new int[Integer.MAX_VALUE/32*2];
		for(int num : nums) {
			setBit(bits, num);
		}
		return getRes(bits);
    }
	
	public void setBit(int[] bits, int num) {
		int div = num/32;
		int mod = num%32;
		bits[div] ^= 1<<mod;
	}
	
	public int[] getRes(int[] bits) {
		List<Integer> res = new ArrayList<>();
		for(int i=0; i<bits.length; i++) {
			if(bits[i]!=0) {
				int index = (int)(Math.log((bits[i]^(bits[i]-1)+1)/2)/Math.log(2));
				res.add(32*i+index);
				bits[i] ^= 1<<index;
				i--;
			}
		}
		return new int[]{res.get(0), res.get(1)};
	}
}