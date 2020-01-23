class Solution{

	public int[] findDiagonalOrder(int[][] matrix){
		int rows = matrix.length;
        if(rows==0) return new int[0];
		int columns = matrix[0].length;
		int index = 0;
            
		int[] order = new int[rows*columns];

		int i=0,j=0;
		boolean up = true;

		while(i<rows && j<columns && index<order.length){
			if(up){
				while(i>=0 && i<rows && j>=0 && j<columns){
					order[index] = matrix[i][j];
					index++;
					i--; j++;
				}
				i++; j--;
				if(i<rows && j<columns-1) j++;
				else if(j==columns-1) i++;
            
				up = false;
			}
			else{
				while(i>=0 && i<rows && j>=0 && j<columns){
					order[index] = matrix[i][j];
					index++;
					i++; j--;
				}
				i--;j++;
				if(j<columns && i<rows-1) i++;
				else if(i==rows-1) j++;
				
				up = true;
			}
		} 

		return order;
	}
}