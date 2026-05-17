class Solution {

    private static final int[][] dir = {{0,-1}, {0,1}, {-1,0}, {1,0}};

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        
        for(int i=0, j=0; j<n;j++){ //row 0
            if(board[i][j] == 'O'){
                dfs(board, i, j);
            }           
        }

        for(int i=m-1, j=0; j<n;j++){ //row m-1
            if(board[i][j] == 'O'){
                dfs(board, i, j);
            }           
        }

        for(int i=1, j=0; i<m-1;i++){  //Col 0
            if(board[i][j] == 'O'){
                dfs(board, i, j);
            }           
        }

        for(int i=1, j=n-1; i<m-1;i++){  //Col n-1
            if(board[i][j] == 'O'){
                dfs(board, i, j);
            }           
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == '#' || board[i][j] == 'Y'){
                    board[i][j] = 'O';
                }
            }
        }

    }

    private void dfs(char[][] board, int i, int j){
        if(i<0 || j<0 || i >= board.length || j >= board[0].length || board[i][j] != 'O'){
            return;
        }
        if(i==0 || i==board.length-1 || j==0 || j==board[0].length-1){
            board[i][j] = '#';
        }else{
            board[i][j] = 'Y';
        }

        for(int[] d : dir){
            dfs(board, i+d[0], j+d[1]);
        }

        return;
    }
}
