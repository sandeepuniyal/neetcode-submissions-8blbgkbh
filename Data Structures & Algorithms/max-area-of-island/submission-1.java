class Solution {
    
    private static final int[][] directions = {{0,-1}, {0,1}, {-1,0},{1,0}};
    
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;
        
        //int noOfIslands = 0;

        boolean[][] visited = new boolean[m][n];

        for(int i=0; i< m; i++){
            for(int j=0; j < n; j++){
                if(grid[i][j] != 0 && !visited[i][j]){
                    int islands = dfs(grid, i, j, visited);
                    //noOfIslands++;
                    maxArea = Math.max(maxArea, islands);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c, boolean[][] visited){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length
            || grid[r][c] == 0 || visited[r][c]){
                return 0;
        }
        visited[r][c] = true;
        int islands = 1;

        for(int[] d: directions){
            islands += dfs(grid, r+d[0], c+d[1], visited);
        }

        return islands;
    }
}
