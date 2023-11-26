//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    private static void dfs(int node, ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {
        visited[node] = true;
        
        for (Integer adjListElement: adjList.get(node)) {
            if (visited[adjListElement] == false) {
                dfs(adjListElement, adjList, visited);
            }
        }
    }
    
    private static void createAdjancencyList(ArrayList<ArrayList<Integer>> adj, int V, ArrayList<ArrayList<Integer>> adjList) {
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for (int i = 0 ; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (adj.get(i).get(j) == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int numOfProvinces = 0;
        boolean[] visited = new boolean[V];
        
        Solution.createAdjancencyList(adj, V, adjList);
        
        
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                Solution.dfs(i, adjList, visited);
                numOfProvinces++;
            }
        }
        
        return numOfProvinces;
        
    }
};