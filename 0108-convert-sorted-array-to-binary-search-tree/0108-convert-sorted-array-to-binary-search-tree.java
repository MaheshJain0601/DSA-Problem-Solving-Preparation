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
    private TreeNode generateArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        
        int mid = start + (end - start)/2;
        
        TreeNode node = new TreeNode(nums[mid]);
        
        node.left = generateArrayToBST(nums, start, mid - 1);
        node.right = generateArrayToBST(nums, mid + 1, end);
        
        return node;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return generateArrayToBST(nums, 0, nums.length - 1);
    }
}