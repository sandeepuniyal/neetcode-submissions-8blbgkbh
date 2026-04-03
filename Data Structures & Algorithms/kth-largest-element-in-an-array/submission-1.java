class Solution {
    public int findKthLargest(int[] nums, int k) {
    
        int l = 0, r = nums.length - 1;
        int pivot = -1;
        while(pivot != k - 1){
            pivot = partition(nums, l, r);
            if(pivot <= k - 1){
                l = pivot + 1;
            }else{
                r = pivot - 1;
            }
        }
        return nums[pivot];
    }

    private int partition(int[] nums, int l, int r){
        int pivot = r;
        int i = l - 1, j= i + 1;
        while(j < r){
            if(nums[j] >= nums[pivot]){
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            j++;
        }
        i++;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return i;
        
    }
}
