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
    private void inOrderRecursive(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        
        inOrderRecursive(root.left, result);
        result.add(root.val);
        inOrderRecursive(root.right, result);
    }
    
    private void inOrderIterative(TreeNode root, List<Integer> result) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                result.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode leftChild = curr.left;

                // Go to the right most child of the leftChild
                while (leftChild.right != null) {
                    leftChild = leftChild.right;
                }

                leftChild.right = curr;
                TreeNode temp = curr;
                curr = curr.left;
                temp.left = null;
            }
        }
        return result;
    }
}