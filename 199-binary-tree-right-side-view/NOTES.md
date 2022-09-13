# Left View of Binary Tree
class Tree
{
private void getLeftView(Node root, int level, ArrayList<Integer> result) {
if (root == null) {
return;
}
if (level == result.size()) {
result.add(root.data);
}
getLeftView(root.left, level + 1, result);
getLeftView(root.right, level + 1, result);
}
//Function to return list containing elements of left view of binary tree.
ArrayList<Integer> leftView(Node root)
{
ArrayList<Integer> result = new ArrayList<>();
getLeftView(root, 0, result);
return result;
}
}
}
}