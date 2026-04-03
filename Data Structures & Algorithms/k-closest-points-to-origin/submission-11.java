class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        int pivot = -1, len = points.length;
        int l = 0, r = len - 1;
        
        while(pivot != k-1){
            pivot = partition(points, l, r);
            System.out.println("pivot= " + pivot);
            if(pivot < k){
                l = pivot + 1;
            }else{
                r = pivot - 1;
            }
        }
        
        int[][] result = new int[k][];
        int i=0;
        while(i<k){
            result[i] = points[i++];
        }
        return result;
    }

    private int partition(int[][] points, int l, int r){
        int i = l-1;
        int j = i + 1;
        int pivot = r;
        int distPivot = distance(points[pivot]);
        while(j < r){
            if(distance(points[j]) <= distPivot){
                i = i+1;
                swap(points, i, j);
            }
            j++;   
        }
        i = i + 1;
        swap(points, i, pivot);
        return i;
    }

    private int distance(int[] a){
        return a[0]*a[0] + a[1]*a[1];
    }

    private void swap(int[][] points, int i , int j){
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}
