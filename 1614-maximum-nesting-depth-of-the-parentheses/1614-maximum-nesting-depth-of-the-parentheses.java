class Solution {
    public int maxDepth(String s) {
        Stack<Character> st = new Stack<>();
        int max_depth =0;

        for(char ch:s.toCharArray()){
            if(ch=='('){
                st.push(ch);
                max_depth = Math.max(max_depth,st.size());
            }else if(ch==')'){
                if(!st.isEmpty()) st.pop();
            }
        }
        return max_depth;
        
    }
}