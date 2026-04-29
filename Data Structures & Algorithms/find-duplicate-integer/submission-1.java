class Solution {
    public int findDuplicate(int[] nums) {
        int val = 0;
        for(int i=0; i < nums.length; i++){
            if(nums[Math.abs(nums[i]) - 1] < 0){
                val =  Math.abs(nums[i]);
            }else{
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }
        return val;
    }
}
