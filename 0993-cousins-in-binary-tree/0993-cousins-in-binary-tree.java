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
    private int findNodeWithHeight(TreeNode root, int target, int[] parentVal, int depth) {
        if (root == null) {
            return 0;
        }
        
        if (root.val == target) {
            return depth;
        }
        
        parentVal[0] = root.val;
        int leftVal = findNodeWithHeight(root.left, target, parentVal, depth+1);
        if (leftVal != 0) {
            return leftVal;
        }
        
        parentVal[0] = root.val;
        int rightVal = findNodeWithHeight(root.right, target, parentVal, depth+1);
        
        return rightVal;    
    }
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null || root.val == x || root.val == y) {
            return false;
        }
        
        int[] xParentVal = new int[1];
        xParentVal[0] = -1;
        int xDepth = findNodeWithHeight(root, x, xParentVal, 0);
        
        int[] yParentVal = new int[1];
        yParentVal[0] = -1;
        int yDepth = findNodeWithHeight(root, y, yParentVal, 0);
        
        return (
            (xDepth == yDepth) 
            &&
            (xParentVal[0] != yParentVal[0])
        );
    }
}