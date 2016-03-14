public class P174 {
    public int calculateMinimumHP(int[][] dungeon) {
		int rows = dungeon.length;
		int cols = dungeon[0].length;
        int[][] needs = new int[rows][cols];
		needs[rows-1][cols-1] = -dungeon[rows-1][cols-1];
		for(int i=rows-2; i>=0; i--) {
			needs[i][cols-1] = Math.max(1,needs[i+1][cols-1]-dungeon[i][cols-1]);
		}
		for(int i=cols-2; i>=0; i--) {
			needs[rows-1][i] = Math.max(1,needs[rows-1][i+1]-dungeon[rows-1][i]);
		}
		for(int i=rows-2; i>=0; i--) {
			for(int j=cols-2; j>=0; j--) {
				needs[i][j] = Math.max(Math.min(needs[i+1][j],needs[i][j+1])-dungeon[i][j],1);
			}
		}
		return needs[0][0]>=0?needs[0][0]:1;
    }
}