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
    public void postorder(TreeNode root, List<Integer> answer) {
        if (root == null) {
            return;
        }
        
        postorder(root.left, answer);
        postorder(root.right, answer);
        answer.add(root.val);
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> answer = new LinkedList<>();
        // Recursive
        // postorder(root, answer);
        // return answer;
        
        // Iterative
        if (root == null) {
            return answer;
        }
        Stack<TreeNode> st1 = new Stack();
        Stack<TreeNode> st2 = new Stack();
        st1.push(root);
        while(!st1.isEmpty()) {
            TreeNode temp = st1.pop();
            st2.push(temp);
            if (temp.left != null) {
                st1.push(temp.left);
            }
            if (temp.right != null) {
                st1.push(temp.right);
            }
        }
        while(!st2.isEmpty()) {
            answer.add(st2.pop().val);
        }
        return answer;
    }
}