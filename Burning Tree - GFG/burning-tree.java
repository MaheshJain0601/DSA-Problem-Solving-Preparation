//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    public static void markParentMapping(Node root, Map<Node, Node> parentMap) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            
            if (node.left != null) {
                parentMap.put(node.left, node);
                queue.offer(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right, node);
                queue.offer(node.right);
            }
        }
    }
    
    public static Node getNode(Node root, int target) {
        if (root == null) {
            return null;
        }
        
        if (root.data == target) {
            return root;
        }
        
        Node leftTree = Solution.getNode(root.left, target);
        if (leftTree != null) {
            return leftTree;
        }
        Node rightTree = Solution.getNode(root.right, target);
        if (rightTree != null) {
            return rightTree;
        }
        return null;
    }
    
    public static int minTime(Node root, int target) 
    {
        Map<Node, Node> parentMap = new HashMap<>();
        Solution.markParentMapping(root, parentMap);
        
        Node node = Solution.getNode(root, target);
        
        int minimumTime = Solution.getMinimumTimeToBurn(root, parentMap, node);
        
        return minimumTime;
        
    }
    
    public static int getMinimumTimeToBurn(Node root, Map<Node, Node> parentMap, Node target) {
        int timeTaken = 0;
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Boolean> visited = new HashMap<>();
        queue.offer(target);
        visited.put(target, true);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean burnt = false;
            for (int index = 0; index < size; ++index) {
                Node node = queue.poll();
                if (node.left != null && !visited.containsKey(node.left)) {
                    burnt = true;
                    queue.offer(node.left);
                    visited.put(node.left, true);
                }
                if (node.right != null && !visited.containsKey(node.right)) {
                    burnt = true;
                    queue.offer(node.right);
                    visited.put(node.right, true);
                }
                
                Node parentNode = parentMap.get(node);
                if (parentNode != null && !visited.containsKey(parentNode)) {
                    burnt = true;
                    queue.offer(parentNode);
                    visited.put(parentNode, true);
                }
            }
            if (burnt)
                timeTaken++;
        }
        return timeTaken;
    }
    
    
}