/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        if (root == null) {
            return result.toString();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node == null) {
                result.append("null ");
                continue;
            }
            result.append(node.val + " ");
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || "".equals(data)) {
            return null;
        }
        String[] values = data.split(" ");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.offer(root);
        TreeNode parent;
        for (int index = 1; index < values.length; ++index) {
            parent = queue.poll();
            if (!"null".equals(values[index])) {
                parent.left = new TreeNode(Integer.parseInt(values[index]));
                queue.offer(parent.left);
            }
            if (!"null".equals(values[++index])) {
                parent.right = new TreeNode(Integer.parseInt(values[index]));
                queue.offer(parent.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;