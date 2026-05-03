class Solution {
    int [] mem = new int[45];
    public int climbStairs(int n) {
        if(n ==0 || n == 1 || n == 2){
            return n;
        }
        if(mem[n-1] == 0) 
            mem[n-1] = climbStairs(n-1);

        if(mem[n-2] == 0) 
            mem[n-2] = climbStairs(n-2);    
        
        return mem[n-1] + mem[n-2];
    }
}
