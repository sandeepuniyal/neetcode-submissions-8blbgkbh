class Solution {
    List<List<Integer>> results = new ArrayList();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ArrayList<Integer> curr = new ArrayList();
        findTargetSum(nums, curr, 0, target);
        return results;
    }

    private void findTargetSum(int[] nums, ArrayList<Integer> curr, int i, int target){
        if(target == 0){
            results.add(new ArrayList(curr)); //results.add(curr); -> Adds reference to curr which will get modified during backtracking and give wrong value
            return;
        }    
        if(target < 0 || i >= nums.length){
            return;
        }
        curr.add(nums[i]);
        findTargetSum(nums, curr, i, target - nums[i]);
        curr.remove(Integer.valueOf(nums[i])); //curr.remove(nums[i]); -> runs into error as it treats nums[i] as index
        findTargetSum(nums, curr, i+1, target);
    }
}
