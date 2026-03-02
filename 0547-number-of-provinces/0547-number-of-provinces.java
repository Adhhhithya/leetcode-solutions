class Solution {
    private static void dfs(int node,ArrayList<ArrayList<Integer>>adjLs,boolean vis[]){
        vis[node] = true;
        for(int i:adjLs.get(node)){
            if(vis[i]==false){
                dfs(i,adjLs,vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<ArrayList<Integer>>();
        int V = isConnected[0].length;
        for(int i=0;i<V;i++){
            adjLs.add(new ArrayList<>());
        }

        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }

        boolean vis[] = new boolean [V+1];
        int cnt =0;
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                cnt++;
                dfs(i,adjLs,vis);
            }
        }
        return cnt;
    }
}