class Solution {
    public int singleNumber(int[] nums) {
        int[] tracker = new int[20001];
        int offset = 10000;
        Arrays.fill(tracker, 1);
        for(int n: nums){
            tracker[n+offset] *= -1;
        }
        for(int i=0; i< tracker.length; i++){
            if(tracker[i] == -1){
                return i - offset;
            }
        }
        return -1;
    }
}
