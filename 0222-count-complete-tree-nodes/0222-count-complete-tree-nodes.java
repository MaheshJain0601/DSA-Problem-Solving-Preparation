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
    // Simple Inorder traversal to count number of nodes
    // Time Complexity: O(N)
    // Space Complexity: O(H)
    public int simpleCountNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return 1 + simpleCountNodes(root.left) + simpleCountNodes(root.right);
        
    }
    
    // Since I halve the tree in every recursive step, I have O(log(n)) steps. Finding a height costs O(log(n)). 
    //Time complexity: O(log(n)^2).
    // Space Complexity: O(H)
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftHeight = 1;
        TreeNode curr = root.left;
        while (curr != null) {
            leftHeight += 1;
            curr = curr.left;
        }
        
        int rightHeight = 1;
        curr = root.right;
        while (curr != null) {
            rightHeight += 1;
            curr = curr.right;
        }
        
        if (leftHeight == rightHeight) {
            return (int)Math.pow(2, leftHeight) - 1;
        }
        
        return 1 + countNodes(root.left) + countNodes(root.right);       
    }
}