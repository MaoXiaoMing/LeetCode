import util.util;

/*
 * Nim Game
 * You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.

Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.

For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.
*/
public class P292 {
	
	public boolean canWinNim(int n) {
		return (n&3)==0?false:true;
		/*if((n&4) == 4) {
			return false;
		}else{
			return true;
		}*/
       /*boolean[] wins1 = new boolean[3];
       boolean[] wins2 = new boolean[3];
       for(int i=0; i<3; i++) {
    	   wins1[i] = true;
    	   wins2[i] = true;
       }
       for(int i=3; i<n; i++) {
    	   boolean result1, result2;
    	   if(!wins2[0] || !wins2[1] || !wins2[2]) {
    		   result1 = true;
    	   }else {
    		   result1 = false;
    	   }
    	   if(!wins1[0] || !wins1[1] || !wins1[2]) {
    		   result2 = true;
    	   }else{
    		   result2 = false;
    	   }
    	   wins1[0] = wins1[1];
    	   wins1[1] = wins1[2];
    	   wins1[2] = result1;
    	   wins2[0] = wins2[1];
    	   wins2[1] = wins2[2];
    	   wins2[2] = result2;
    	   System.out.println(i+"\t"+result2);
       }
       return wins1[2];*/
	}
	
	public static void main(String[] args) {
		util.p(new P292().canWinNim(20));
	}
	
}
