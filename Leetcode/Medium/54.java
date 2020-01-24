class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        int rows = matrix.length;
        if(rows==0) return order;
        int columns = matrix[0].length;
        int direction = 1;
        int i=0,j=0;
        int numElements = rows*columns;
        
        
        while(numElements>0){
            while((i<rows && j<columns && i>=0 && j>=0) && matrix[i][j]!=-1000){
                order.add(matrix[i][j]);
                matrix[i][j]=-1000;
                
                if(direction==1)j++;
                else if(direction==2)i++;
                else if(direction==3)j--;
                else if(direction==4)i--;
                numElements--;
            }
            if(direction==1){
                i++;
                j--;
            }else if(direction==2){
                i--;
                j--;
            }else if(direction==3){
                j++;
                i--;
            }else if(direction==4){
                i++;
                j++;
            }
            direction++;
            if(direction==5)direction=1;
        } 
        return order;
    }
}