class Solution {
    int[][] directions = {{0,-1}, {0,1}, {-1,0},{1,0}};

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int noOfIslands = 0;

        boolean[][] visited = new boolean[m][n];

        for(int i=0; i< m; i++){
            for(int j=0; j < n; j++){
                if(grid[i][j] != '0' && !visited[i][j]){
                    dfs(grid, i, j, visited);
                    noOfIslands++;
                }
            }
        }
        return noOfIslands;
    }

    private void dfs(char[][] grid, int r, int c, boolean[][] visited){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length
            || grid[r][c] == '0' || visited[r][c]){
                return;
        }
        visited[r][c] = true;

        for(int[] d: directions){
            dfs(grid, r+d[0], c+d[1], visited);
        }
    }
}
