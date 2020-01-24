class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if(numRows==0) return triangle;
        
        int k=0;
        while(k<numRows){
            List<Integer> row = new ArrayList<>();
            row.add(1);
            triangle.add(row);
            k++;
        }
        for(int i=1;i<triangle.size();i++){
            List<Integer> previousRow = triangle.get(i-1);
            List<Integer> currentRow = triangle.get(i);
            
            for(int j=1;j<previousRow.size();j++){
                currentRow.add(previousRow.get(j-1) + previousRow.get(j));
            }
            currentRow.add(1);
        }
        return triangle;
    }
}