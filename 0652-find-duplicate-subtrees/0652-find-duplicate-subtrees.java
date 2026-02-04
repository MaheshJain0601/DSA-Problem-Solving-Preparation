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
    // TC: O(N^2)
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
    public List<TreeNode> findDuplicateSubtreesSimple(TreeNode root) {
        Map<String, Integer> hashMap = new HashMap<>();

        List<TreeNode> result = new ArrayList<>();
        findDuplicateSubtreesHelper(root, hashMap, result);

        return result;
    }
    // Approach-2
    private int nextSubtreeId = 1; // 0 reserved for null subtree

    private int findDuplicateSubtreesHelperV2(TreeNode root, List<TreeNode> result, 
                    Map<String, Integer> signatureToId,
                    Map<Integer, Integer> freq) {
        if (root == null) return 0;

        int leftId = findDuplicateSubtreesHelperV2(root.left, result, signatureToId, freq);
        int rightId = findDuplicateSubtreesHelperV2(root.right, result, signatureToId, freq);

        String signature = new StringBuilder()
                .append(root.val).append(',')
                .append(leftId).append(',')
                .append(rightId)
                .toString();

        int id = signatureToId.computeIfAbsent(signature, s -> nextSubtreeId++);
        // System.out.println(signatureToId);

        int newCount = freq.getOrDefault(id, 0) + 1;
        freq.put(id, newCount);

        if (newCount == 2) result.add(root);

        return id;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> hashMap = new HashMap<>();

        List<TreeNode> result = new ArrayList<>();
        Map<String, Integer> signatureToId = new HashMap<>();   // String is correct key
        Map<Integer, Integer> freq = new HashMap<>();
        findDuplicateSubtreesHelperV2(root, result, signatureToId, freq);

        return result;
    }
}