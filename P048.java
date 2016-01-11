
public class P048 {

    public static void rotate(int[][] matrix) {
        for(int i=0; i<matrix.length; i++) {
        	for(int j=i+1; j<matrix.length-i; j++) {
        		int temp = matrix[i][j];
        		matrix[i][j] = matrix[matrix.length-1-j][i];
        		matrix[matrix.length-1-j][i] = matrix[matrix.length-i-1][matrix.length-j-1];
        		matrix[matrix.length-i-1][matrix.length-j-1] = matrix[j][matrix.length-i-1];
        		matrix[j][matrix.length-i-1] = temp;
        	}
        }
    }
	
	public static void main(String[] args) {
		rotate(new int[][]{{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}});
	}

}
