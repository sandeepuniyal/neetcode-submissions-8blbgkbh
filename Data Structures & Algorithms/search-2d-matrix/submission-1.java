class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int start=0, end=m-1, middle;
        int row=-1;
        while(start <= end){
            middle = start + (end - start)/2;
            //System.out.println("start=" +start + " end= " + start +  " middle= " + middle);
            if(target >= matrix[middle][0] && target <=  matrix[middle][n-1]){
                row = middle;
                break;
            }else if(target < matrix[middle][0] ){
                end = middle - 1;
            }else{
                start = middle + 1;
            }
        }
        //System.out.println("m=" + m + " ,n= " + n);
        if(row < 0){
            return false;
        }
        //System.out.println("row=" + row);

        start = 0; end = n-1;
        while(start <= end){
            middle= start + (end-start)/2;
             //System.out.println("start=" +start + " end= " + start +  " middle= " + middle);
            if(target == matrix[row][middle]){
                return true;
            }else if(target < matrix[row][middle] ){
                end = middle - 1;
            }else{
                start = middle + 1;
            }
        }

        return false;

    }
}
