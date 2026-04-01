class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Arrays.stream(piles).max().getAsInt();;
        int k;
        int k_min = r;
        while (l <= r){
            k = (l + r)/2;
            int hours = 0;
            for(int p: piles){
                hours += Math.ceil((double)p/k);
            }
            if(hours > h){ 
                l = k+1;
            }else{
                r = k-1;
                k_min = k;
            }
            
        }
        return k_min;
    }
}
