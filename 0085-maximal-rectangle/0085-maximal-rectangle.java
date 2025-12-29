class Solution {
        public static int max_area_rectangle(int arr[]){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&& arr[st.peek()]>arr[i]){
                int el = st.peek();
                st.pop();
                int nse = i;
                int pse = st.isEmpty()?-1:st.peek();
                maxArea = Math.max(maxArea,arr[el]*(nse-pse-1));
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int nse = n;
            int el = st.peek();
            st.pop();
            int pse = st.isEmpty()?-1:st.peek();
            maxArea = Math.max(maxArea,arr[el]*(nse-pse-1));
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if(n==0) return 0;
        int m = matrix[0].length;
        int maxArea =0;
        int pre_sum[][] = new int[n][m];
        for(int j =0;j<m;j++){
            int sum =0;
            for(int i=0;i<n;i++){
                if(matrix[i][j]=='1'){
                    sum+=1;
                }else{
                    sum=0;
                }
                pre_sum[i][j]=sum;
            }
        }
        for(int i=0;i<n;i++){
            maxArea = Math.max(maxArea,max_area_rectangle(pre_sum[i]));
        }
        return maxArea;
    }
}