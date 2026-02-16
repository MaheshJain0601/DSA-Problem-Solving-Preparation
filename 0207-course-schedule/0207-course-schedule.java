class Solution {
    private List<List<Integer>> getAdjacencyList(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0;i < numCourses;i++){
            adjList.add(new ArrayList<>());
        }
        for (int index = 0; index < prerequisites.length; ++index) {
            int v = prerequisites[index][0];
            int u = prerequisites[index][1];
            adjList.get(u).add(v);
        }
        return adjList;
    }
    // Topological Sort - BFS
    // Kahn's Algorithm
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = getAdjacencyList(numCourses, prerequisites);

        System.out.println(adjList);
        
        // Topological Sort
        int[] indegree = new int[numCourses];
        for (int vertice = 0; vertice < adjList.size(); ++vertice) {
            for (Integer adjNode: adjList.get(vertice)) {
                indegree[adjNode]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int vertice = 0; vertice < numCourses; ++vertice) {
            if (indegree[vertice] == 0) {
                queue.offer(vertice);
            }
        }

        int counter = 0;
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            counter++;
            for (Integer adjNode: adjList.get(node)) {
                indegree[adjNode]--;
                if (indegree[adjNode] == 0) {
                    queue.offer(adjNode);
                }
            }
        }

        return counter == numCourses;
    }

    
}