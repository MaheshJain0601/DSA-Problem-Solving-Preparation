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
    class Pair {
        int sum;
        int numOfNodes;
        
        public Pair(int sum, int numOfNodes) {
            this.sum = sum;
            this.numOfNodes = numOfNodes;   
        }
    }
    
    private Pair countAvergaeOfSubtreeHelper(TreeNode root, int[] result) {
        if (root == null) {
            return null;
        }
        
        int totalSum = 0;
        int totalNodes = 0;
        
        Pair left = countAvergaeOfSubtreeHelper(root.left, result);
        if (left != null) {
            totalSum += left.sum;
            totalNodes += left.numOfNodes;
        }
        Pair right = countAvergaeOfSubtreeHelper(root.right, result);
        if (right != null) {
            totalSum += right.sum;
            totalNodes += right.numOfNodes;
        }
        totalSum += root.val;
        totalNodes += 1;
        
        int avg = (int)(totalSum/totalNodes);
        if (avg == root.val) {
            result[0] += 1;
        }
        
        return new Pair(totalSum, totalNodes);
    }
    
    public int averageOfSubtree(TreeNode root) {
        int[] result = new int[1];
        result[0] = 0;
        
        countAvergaeOfSubtreeHelper(root, result);
        
        return result[0];
    }
}