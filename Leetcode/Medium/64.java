class Solution {
    public int minPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        //Step 1: calculate paths downward
		for(int i=1;i<m;i++) {
			matrix[i][0]=matrix[i-1][0] + matrix[i][0];
		}

		//Step 2: calculate paths sideways
		for(int j=1;j<n;j++) {
			matrix[0][j]=matrix[0][j-1] + matrix[0][j];
		}

		//Step 3: calculate minimum path
		for(int i=1;i<m;i++) {
			for(int j=1;j<n;j++) {
				int minPath = Math.min(matrix[i-1][j], matrix[i][j-1]);
				matrix[i][j] = matrix[i][j] + minPath;
			}
		}

        return matrix[m-1][n-1];
    }
}