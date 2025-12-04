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
    private void inOrder(TreeNode node, List<Integer> result) {
        if (node == null) return;

        inOrder(node.left, result);

        result.add(node.val);

        inOrder(node.right, result);
    }

    // public void inOrderTraversal(TreeNode root1, TreeNode root2, List<Integer> result) {
    //     if (root1 == null && root2 == null) {
    //         return;
    //     }

    //     if (root1 == null) {
    //         inOrder(root2, result);
    //         return;
    //     } else if (root2 == null) {
    //         inOrder(root1, result);
    //         return;
    //     } 

    //     inOrderTraversal(root1.left, root2.left, result);
    //     if (root1.val <= root2.val) {
    //         result.add(root1.val);
    //         inOrderTraversal(root1.left, root2, result);
    //     } else {
    //         result.add(root2.val);
    //         inOrderTraversal(root1, root2.right, result);
    //     }
    //     inOrderTraversal(root1.right, root2.right, result);
    // }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> inOrder1 = new LinkedList<>();
        inOrder(root1, inOrder1);

        List<Integer> inOrder2 = new LinkedList<>();
        inOrder(root2, inOrder2);

        List<Integer> result = new LinkedList<>();
        int index1 = 0, index2 = 0;
        int s1 = inOrder1.size(), s2 = inOrder2.size();

        while (index1 < s1 && index2 < s2) {
            if (inOrder1.get(index1) <= inOrder2.get(index2)) {
                result.add(inOrder1.get(index1));
                index1++;
            } else {
                result.add(inOrder2.get(index2));
                index2++;
            }
        }

        while (index1 < s1) {
            result.add(inOrder1.get(index1));
            index1++;
        }

        while (index2 < s2) {
            result.add(inOrder2.get(index2));
            index2++;
        }

        return result;
    }
}