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
        int count = 0;
        TreeNode result = null;

    public int kthSmallest(TreeNode root, int k) {
        traversal(root, k);
        return result.val;
    }

    private void traversal(TreeNode root, int k){
        if(root == null || result != null) return; 
        
        traversal(root.left, k);
        
        count++;
        //System.out.println("Count is " + count + " for root " + root.val);
        if(count == k){ //root
            result = root;
            return;
        }

        traversal(root.right, k);

        return;

    }
}
