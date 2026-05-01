class KthLargest {
    PriorityQueue<Integer> stream = new PriorityQueue<>((a,b) -> (b - a));
    int k;
        
    public KthLargest(int k, int[] nums) {
        for(int n: nums){
            stream.add(n);
        }
        this.k = k;
    }
    
    public int add(int val) {
        stream.add(val);
        return kthLargest();
    }

    private int kthLargest(){
        ArrayList<Integer> buffer = new ArrayList();
        int n=-1;
        for(int i=1; i<= this.k; i++){
            n = stream.poll();
            buffer.add(n);
        }
        stream.addAll(buffer);
        return n;
    }


}
