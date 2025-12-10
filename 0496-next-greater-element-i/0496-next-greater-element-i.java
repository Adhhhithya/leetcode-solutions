class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int nge[] = new int[n1];
        int nge2[] = new int[n2];
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> mpp = new HashMap<>();

        for(int i=n2-1;i>=0;i--){
            while(!st.empty() && st.peek()<=nums2[i]){
                st.pop();
            }
            if(st.empty()){
                nge2[i]=-1;
            }else{
                nge2[i]=st.peek();
            }
            st.push(nums2[i]);
        }

        for(int i=0;i<n2;i++){
            mpp.put(nums2[i],nge2[i]);
        }
        for(int i=0;i<n1;i++){
            nge[i] = mpp.getOrDefault(nums1[i],-1);
        }

        return nge;

        
    }
}