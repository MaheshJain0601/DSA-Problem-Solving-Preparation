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
    private String findDuplicateSubtreesHelper(TreeNode root, Map<String, Integer> hashMap, List<TreeNode> result) {
        if (root == null) {
            return "N";
        }

        String leftSubtree = findDuplicateSubtreesHelper(root.left, hashMap, result);
        String rightSubtree = findDuplicateSubtreesHelper(root.right, hashMap, result);

        String currentStructure = root.val + "," + leftSubtree + "," + rightSubtree;
        if (hashMap.getOrDefault(currentStructure, 0) == 1) {
            result.add(root);
        }
        hashMap.put(currentStructure, hashMap.getOrDefault(currentStructure, 0) + 1);
        
        return currentStructure;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> hashMap = new HashMap<>();

        List<TreeNode> result = new ArrayList<>();
        findDuplicateSubtreesHelper(root, hashMap, result);

        return result;
    }
}