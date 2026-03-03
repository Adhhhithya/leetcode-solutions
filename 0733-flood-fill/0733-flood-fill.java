class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ini = image[sr][sc];
        int ans[][] = image;
        int[] delta_row = {-1,0,1,0};
        int[] delta_col = {0,1,0,-1};
        
        dfs(sr,sc,ini,color,image,ans,delta_row,delta_col);
        return ans;
    }

    private static void dfs(int row,int col,int initColor , int newColor , int[][]image,int[][]ans,int[] delta_row,int[] delta_col){
        ans[row][col] = newColor;
        int n = image.length;
        int m = image[0].length;

        for(int i=0;i<4;i++){
            int nRow = row + delta_row[i];
            int nCol = col + delta_col[i];

            if(nRow>=0 && nRow <n &&
            nCol>=0 && nCol <m &&
            image[nRow][nCol]==initColor &&
            ans[nRow][nCol]!=newColor){
                dfs(nRow,nCol,initColor,newColor,image,ans,delta_row,delta_col);
            }
        }
    }
}