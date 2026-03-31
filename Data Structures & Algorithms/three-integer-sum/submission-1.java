class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        /*for(int n: nums){
            System.out.print(n + ", ");
        }*/
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i< nums.length; i++){
            List<int[]> pairs = findPairWithSum(nums, i, -1 * nums[i]);
            if(pairs != null){
                for(int[] pair: pairs ){
                    result.add(Arrays.asList(nums[i], pair[0], pair[1]));
                }
                
            }
            while( i< nums.length - 1 && nums[i] == nums[i+1]){
                //System.out.println("Values at index " + i + " and " + (i+1) + " are same.. Skipping " + (i+1));
                i++;
            }
        }
        return result;
    }

    private ArrayList<int[]> findPairWithSum(int[] nums, int index, int target){
        int l = index + 1, r = nums.length - 1;
        ArrayList<int []> res = new ArrayList<>();
        //System.out.println("\nChecking pair with sum " + target+ " for index " + index);
        while(l < r){
            int sum = nums[l] + nums[r];
            if(sum == target){
                //System.out.println("Found pair: ["+ nums[l] +  ", " + nums[r] + "] for index "+ index + " ");
                res.add(new int[]{nums[l], nums[r]});
                while( l < r && nums[l] == nums[l+1]) { l++; }
                while( l< r && nums[r] == nums[r-1]) { r--; }
                l++;
                r--;
            }else if (sum < target){
                l++;
            }else{
                r--;
            }
        }
        return res;
    }
}
