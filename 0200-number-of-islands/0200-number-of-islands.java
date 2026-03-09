class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    private static void bfs(int ro,int co,int[][] vis,char[][]grid){
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        vis[ro][co] = 1;
        q.add(new Pair(ro,co));

        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            for(int i=0;i<4;i++){
                    int n_row = row + delrow[i];
                    int n_col = col + delcol[i];

                    if(n_row>=0 && n_row<n &&
                    n_col>=0 && n_col<m &&
                    vis[n_row][n_col]==0 &&
                    grid[n_row][n_col]=='1'){
                        vis[n_row][n_col]=1;
                        q.add(new Pair(n_row,n_col));
                    }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int vis[][] = new int[n][m];
        int cnt =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    cnt++;
                    bfs(i,j,vis,grid);
                }
            }
        }
        return cnt;
    }
}