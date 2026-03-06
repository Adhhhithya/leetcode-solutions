class Pair{
    int row,col,tm;
    Pair(int row,int col,int _tm){
        this.row = row;
        this.col = col;
        this.tm = _tm;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        int cnt_fresh =0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1) cnt_fresh++;
            }
        }

        int[] del_row = {-1,0,1,0};
        int[] del_col = {0,1,0,-1};
        int tm =0;
        int cnt =0;

        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().tm;
            tm = Math.max(tm,t);
            q.remove();

            for(int i=0;i<4;i++){
                int nrow = r + del_row[i];
                int ncol = c + del_col[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    q.add(new Pair(nrow,ncol,t+1));
                    vis[nrow][ncol]=2;
                    cnt++;
                }
            }
        }
        if(cnt!=cnt_fresh) return -1;
        return tm;
    }
}