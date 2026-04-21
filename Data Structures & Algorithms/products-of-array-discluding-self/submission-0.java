class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        int[] prefixProduct = new int[l];
        int[] suffixProduct = new int[l];
        int[] result = new int[l];

        prefixProduct[0] = 1;
        for(int i=1; i< l; i++){
            prefixProduct[i] = nums[i-1] * prefixProduct[i-1];
        }

        suffixProduct[l-1] = 1;
        for(int i=l-2; i>= 0; i--){
            suffixProduct[i] = nums[i+1] * suffixProduct[i+1];
        }

        for(int i=0; i< l; i++){
            result[i] = prefixProduct[i] * suffixProduct[i];
        }

        return result;

     }
}  
