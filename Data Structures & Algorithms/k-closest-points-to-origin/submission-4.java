class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a,b) -> {
                int d1 = a[0]*a[0] + a[1]*a[1];
                int d2 = b[0]*b[0] + b[1]*b[1];
                return Integer.compare(d2, d1); //max heap
        });

        for(int[] p: points){
            heap.offer(p);
            if(heap.size() > k){
                heap.poll();
            }
        }

        int[][] result = new int[k][];
        int i=k-1;
        for(int [] p: heap){
            result[i--] = p;
        }
        return result;
    }
}
