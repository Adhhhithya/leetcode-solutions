class Solution {
    private int[] find_NGE(int arr[]){
        int n = arr.length;
        int nge[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&& arr[st.peek()]<arr[i]){
                st.pop();
            }
            nge[i] = !st.isEmpty() ? st.peek() : n;
            st.push(i);
        }
        return nge;
    }

    private static int[] find_NSE(int arr[]){
        int n = arr.length;
        int nse[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            nse[i] = !st.isEmpty() ? st.peek() : n;
            st.push(i);
        }
        return nse;
    }

    private static int[] find_PGE(int arr[]){
        int n = arr.length;
        int pge[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
                st.pop();
            }
            pge[i] = !st.isEmpty() ? st.peek() : -1;
            st.push(i);
        }
        return pge;
    }

    private static int[] find_PSE(int arr[]){
        int n = arr.length;
        int pse[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            pse[i] = !st.isEmpty() ? st.peek():-1;
            st.push(i);
        }
        return pse;
    }

    public long sum_max(int arr[]){
        int n = arr.length;
        int nge[] = find_NGE(arr);
        int pge[] = find_PGE(arr);
        long sum =0;
        for(int i=0;i<n;i++){
            int left = i - pge[i];
            int right = nge[i] - i;
            long freq = (left*right*1L);
            sum += freq*arr[i];
        }
        return sum;
    }

    public long sum_min(int arr[]){
        int n = arr.length;
        int nse[] = find_NSE(arr);
        int pse[] = find_PSE(arr);
        long sum =0;
        for(int i=0;i<n;i++){
            int left = i - pse[i];
            int right = nse[i] -i;
            long freq = (left*right*1L);
            sum += freq*arr[i];
        }
        return sum;
    }
    public long subArrayRanges(int[] nums) {
        return sum_max(nums) - sum_min(nums);
    }
}