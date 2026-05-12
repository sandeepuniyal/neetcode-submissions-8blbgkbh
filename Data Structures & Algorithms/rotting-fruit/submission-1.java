class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i< grid.length; i++){
            for(int j=0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i,j,0});
                }  
            }
        }

        int[][] dir = new int[][]{{0,-1}, {0,1}, {-1,0}, {1,0}};
        int finalCount = 0;
        while(!queue.isEmpty()){
            int[] fruit = queue.poll();
            int r = fruit[0];
            int c = fruit[1];
            int count = fruit[2];
            for(int[] d: dir){
                int nr = r + d[0];
                int nc = c + d[1];
                if(nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length
                || grid[nr][nc] != 1){
                    continue;
                }
                queue.add(new int[]{nr, nc, count+1});
                grid[nr][nc] = 2;
                finalCount = count + 1;
            }
        }
        for(int i=0; i< grid.length; i++){
            for(int j=0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    return -1;
                }  
            }
        }
        return finalCount;
    }
}
