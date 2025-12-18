class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        List<Integer> st = new ArrayList<>();
        for(int i=0;i<n;i++){
            int curr = asteroids[i];
            if(curr > 0){
                st.add(curr);
            }else{
                while(!st.isEmpty() && st.get(st.size()-1) >0 && st.get(st.size()-1)<Math.abs(curr)){
                    st.remove(st.size()-1);
                }
                if(!st.isEmpty() && st.get(st.size()-1)==Math.abs(curr)){
                    st.remove(st.size()-1);
                }else if(st.isEmpty()||st.get(st.size()-1)<0){
                    st.add(curr);
                }
            }
        }
        int res[] = new int[st.size()];
        for(int i=0;i<st.size();i++){
            res[i] = st.get(i);
        }
        return res;
    }
}