/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode dummy = new TreeNode(Integer.MAX_VALUE);
        q.add(root);
        q.add(dummy);

        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> batch;

        result.add(Arrays.asList(root.val));

        while(!q.isEmpty()){
            batch = new ArrayList<>();
            TreeNode n = q.poll();
            while(n !=  dummy){
                if(leaf(n)){
                    n = q.poll();
                    continue;
                }
                if(n.left != null){
                    q.add(n.left);
                    batch.add(n.left.val);
                }
                if(n.right != null){
                    q.add(n.right);
                    batch.add(n.right.val);
                }
                n = q.poll();
            }
            if(!batch.isEmpty()){
                q.add(dummy);
                result.add(batch);
            }
            
        }
        return result;
    }

    private boolean leaf(TreeNode n){
        return n.left == null && n.right == null;
    }
}
