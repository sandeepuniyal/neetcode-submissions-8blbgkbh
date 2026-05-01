class KthLargest {
    PriorityQueue<Integer> stream = new PriorityQueue<>();
    int k;
        
    public KthLargest(int k, int[] nums) {
        for(int n: nums){
            stream.add(n);
            if(stream.size() > k){
                stream.poll();
            }
        }
        this.k = k;
    }
    
    public int add(int val) {
        stream.add(val);
        if(stream.size() > k){
            stream.poll();
        }
        return stream.peek();
    }

}
