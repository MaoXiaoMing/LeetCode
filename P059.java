
/*
59. Spiral Matrix II
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/
public class P059 {
	
    public int[][] generateMatrix(int n) {
    	int count = 1;
        int[][] res = new int[n][n];
        for(int i=0; i<(n+1)/2; i++) {
        	for(int j=i; j<=n-i-1; j++) res[i][j]=count++;
        	for(int j=i+1; j<=n-i-1; j++) res[j][n-1-i]=count++;
        	for(int j=n-i-2; j>=i; j--) res[n-i-1][j]=count++;
        	for(int j=n-2-i; j>i; j--) res[j][i]=count++;
        }
        return res;
    }
	
	public static void main(String[] args) {

	}

}
