class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int p: piles){
            max = Math.max(max, p);
        }

        int l = 1, r = max;
        int k;
        int k_min = Integer.MAX_VALUE;
        while (l <= r){
            k = (l + r)/2;
            int hours = 0;
            for(int p: piles){
                //System.out.println("for p=" + p + " and k= " + k + " hours=" + Math.ceil((double)p/k));
                hours += Math.ceil((double)p/k);
            }
            //System.out.println("Hours required for k=" + k + " is " + hours);
            if(hours > h){ 
                l = k+1;
            }else{
                r = k-1;
                k_min = Math.min(k, k_min);
            }
            
        }
        return k_min;
    }
}
