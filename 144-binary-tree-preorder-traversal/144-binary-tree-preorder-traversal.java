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
    public void preorder(TreeNode root, List<Integer> answer) {
        if (root == null) {
            return;
        }
        
        answer.add(root.val);
        preorder(root.left, answer);
        preorder(root.right, answer);
        
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> answer = new LinkedList<>();
        // Recursive
        // preorder(root, answer);
        if (root == null) {
            return answer;
        }
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode temp = st.pop();
            answer.add(temp.val);
            if (temp.right != null) {
                st.push(temp.right);
            }
            if (temp.left != null) {
                st.push(temp.left);
            }
        }
        return answer;  
    }
}