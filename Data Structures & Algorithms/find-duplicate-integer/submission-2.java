class Solution {
    public int findDuplicate(int[] nums) {
        int val = 0;
        for(int i=0; i < nums.length; i++){
            if(nums[abs(nums[i]) - 1] < 0){
                val = abs(nums[i]);
            }else{
                nums[abs(nums[i]) - 1] *= -1;
            }
        }
        return val;
    }

    private int abs(int n){
        return (n < 0) ? (n * -1 ): n;
    }
}
