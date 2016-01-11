
public class P135 {
	
    public int candy(int[] ratings) {
    	int[] aux = new int[ratings.length];
    	for(int i=0; i<aux.length; i++) aux[i] = 1;
    	int count = 1;
    	for(int i=1; i<ratings.length; i++) {
    		if(ratings[i] > ratings[i-1]) {
    			aux[i] = aux[i-1]+1;
    		}
    		count += aux[i];
    	}
    	for(int i=ratings.length-2; i>=0; i--) {
    		if(ratings[i] > ratings[i+1] && aux[i] < aux[i+1]+1) {
    			count += aux[i+1]-aux[i]+1;
    			aux[i] = aux[i+1]+1;
    		} 
    	}
    	return count;
    }
	
//    public int candy(int[] ratings, int index) {
//    	if(memo[index] != 0) return memo[index];
//    	if(index == 0) {
//    		if(ratings[0] < ratings[1]) return memo[0] = 1;
//    		else return memo[0]=candy(ratings, 1)+1;
//    	}else if(index == ratings.length-1) {
//    		if(ratings[index] < ratings[index-1]) return memo[index]=1;
//    		else return memo[index]=candy(ratings, index-1)+1;
//    	}else {
//    		if(ratings[index]<ratings[index-1] && ratings[index]<ratings[index+1]) {
//    			return memo[index]=1;
//    		}else if(ratings[index]>ratings[index-1] && ratings[index]>ratings[index+1]) {
//    			return memo[index]=Math.max(candy(ratings, index-1), candy(ratings, index+1))+1;
//    		}
//    		else if(ratings[index-1] > ratings[index+1]) {
//    			return memo[index]=candy(ratings, index+1)+1;
//    		}else {
//    			return memo[index]=candy(ratings, index-1)+1;
//    		}
//    	}
//    }
    
	public static void main(String[] args) {
		System.out.println(new P135().candy(new int[]{2,3,4,2,4,5}));
	}

}
