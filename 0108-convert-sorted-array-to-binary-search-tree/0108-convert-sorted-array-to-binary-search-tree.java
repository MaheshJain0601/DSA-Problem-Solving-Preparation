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
    private TreeNode convertToBST(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        
        int mid = ((high - low) / 2) + low;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = convertToBST(nums, low, mid - 1);
        node.right = convertToBST(nums, mid + 1, high);
        
        return node;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length <= 0) {
            return null;
        }
        TreeNode root = convertToBST(nums, 0, nums.length - 1);
        return root;
    }
}