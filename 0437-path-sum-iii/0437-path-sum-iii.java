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
    // Brute force
    // TC: O(N^2)
    private int pathSumBruteHelper(TreeNode root, int targetSum) {
        if (root == null) return 0;
        int countPaths = 0;
        if (targetSum == root.val) {
            countPaths = 1;
        }
        int newSum = targetSum - root.val;
        countPaths += pathSumBruteHelper(root.left, newSum);
        countPaths += pathSumBruteHelper(root.right, newSum);
        return countPaths;
    }
    public int pathSumBrute(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        return pathSumBrute(root.left, targetSum)
            + pathSumBrute(root.right, targetSum)
            + pathSumBruteHelper(root, targetSum);
    }

    // Approach-2: Optimised
    private int pathSumHelper(TreeNode root, Map<Long, Integer> preSum, long runningSum, int targetSum) {
        if (root == null) {
            return 0;
        }

        runningSum += root.val;
        int countPaths = preSum.getOrDefault(runningSum - targetSum, 0);
        preSum.put(runningSum, preSum.getOrDefault(runningSum, 0) + 1);
        
        // Left, Right Subtree exploration
        countPaths += pathSumHelper(root.left, preSum, runningSum, targetSum);
        countPaths += pathSumHelper(root.right, preSum, runningSum, targetSum);

        // Backtrack removal
        preSum.put(runningSum, preSum.get(runningSum) - 1);
        if (preSum.get(runningSum) == 0) {
            preSum.remove(runningSum);
        }
        
        return countPaths;
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        Map<Long, Integer> mp = new HashMap<>();
        mp.put(0L, 1);
        return pathSumHelper(root, mp, 0L, targetSum);
    }
}