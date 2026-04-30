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
    private int maxLength = - 1;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return maxLength;
    }

    private int diameter(TreeNode root){
        if(root== null){
            return 0;
        }
        int left = diameter(root.left);
        int right = diameter(root.right);
        
        int len = left + right;
        maxLength = maxLength >= len ? maxLength : len;

        return left > right ? left + 1 : right + 1;
    }
}
