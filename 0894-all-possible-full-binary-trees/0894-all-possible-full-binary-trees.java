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
    HashMap<Integer, List<TreeNode>> possibleFBTs= new HashMap<>();
    
    private List<TreeNode> allPossibleFBTHelper(int n) {
        
        List<TreeNode> result = new ArrayList<>();
        
        if (n % 2 == 0) {
            return result;
        }
        
        if (n == 1) {
            result.add(new TreeNode(0));
            return result;
        }
        
        if (possibleFBTs.get(n) != null) {
            return possibleFBTs.get(n);
        }
        
        for (int index = 1; index < n; index+=2) {
            List<TreeNode> leftFBTs = allPossibleFBTHelper(index);
            List<TreeNode> rightFBTs = allPossibleFBTHelper(n-index-1);
            
            for (TreeNode leftNode: leftFBTs) {
                for (TreeNode rightNode: rightFBTs) {
                    TreeNode node = new TreeNode(0);
                    node.left = leftNode;
                    node.right = rightNode;
                    result.add(node);
                }
            }
        }
        possibleFBTs.put(n, result);
        
        return result; 
    }
    public List<TreeNode> allPossibleFBT(int n) {
        return allPossibleFBTHelper(n);
    }
}