class Solution {
    
    public boolean validTree(int n, int[][] edges) {
        int[][] graph = new int[n][n];
        Set<Integer> visited = new HashSet<>();
        for(int [] row: graph){
            Arrays.fill(row, -1);
        }
        for(int[] edge: edges){
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }
            
        return dfs(-1, 0, graph, visited) && (visited.size() == n);
    }

    private boolean dfs(int parent, int i, int[][] graph, Set<Integer> visited){
        if(visited.contains(i))
            return false;

        visited.add(i);

        for(int j = 0; j < graph.length; j++){
            if(graph[i][j] == 1 && j != parent){
                if(!dfs(i, j, graph, visited)){
                    return false;
                }
            }
        }
        return true;
    }
}
