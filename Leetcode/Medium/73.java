class Solution {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> columns = new HashSet<>();
        
        for(int i=0;i<matrix.length;++i){
            for(int j=0;j<matrix[0].length;++j){
                if(matrix[i][j]==0){
                    rows.add(i);
                    columns.add(j);
                    //System.out.println("Row: " + i + " Column: " + j);
                }
            }
        }
        
        for(int i=0;i<matrix.length;++i){
            for(int j=0;j<matrix[0].length;++j){
                if(rows.contains(i) || columns.contains(j)) matrix[i][j]=0;
            }
        }
    }
}