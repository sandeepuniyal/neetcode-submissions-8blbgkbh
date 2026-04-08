class Solution {
    List<List<Integer>> results = new ArrayList();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<Integer> curr = new ArrayList();
        Arrays.sort(candidates);
        findTargetSum(candidates, target, curr, 0);
        return results;
    }

    private void findTargetSum(int[] candidates, int target, ArrayList<Integer> curr, int i ){
        if(target == 0){
            results.add(new ArrayList(curr));
            return;
        }
        if(target < 0 || i >= candidates.length){
            return;
        }
        curr.add(candidates[i]);
        findTargetSum(candidates, target - candidates[i], curr, i+1);
        while( i+1 < candidates.length && candidates[i+1] == candidates[i]){
            i++;
        }
        curr.remove(curr.size() - 1);
        findTargetSum(candidates, target, curr, i+1);
    }
}
