class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*
        For cases where array isn't sorted and can have both -ve and +ve numbers
    , the approach best suited is to make a hashmap and NOT the two pointer approach
    Given A + B = target, we are looking to find (A = target - B) which means that whenever
    we are visting element B, we are looking to find (target - B) i.e elements A which is 
    essentially difference of target and the other element. We maintain a hashmap
    and keep storing the 'element' with its index if (target-element) doesn't exist
        */
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++){
            if(m.containsKey(target - nums[i])){
                return new int[]{m.get(target - nums[i]), i};
            }
            m.put(nums[i], i);
        }  
        return null;   
    }   
}
