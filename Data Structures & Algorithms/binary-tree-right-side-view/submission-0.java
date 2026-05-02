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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> rightView = new ArrayList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode node = null;
            int currSize = q.size();
            for(int i=0; i< currSize; i++){
                node = q.poll();
                if(node != null){
                    if(node.left != null){
                        q.offer(node.left);
                    }
                    if(node.right != null){
                        q.offer(node.right);
                    }
                }
            }
            if(node != null){
                rightView.add(node.val);
            }
        }
        return rightView;
    }
}
