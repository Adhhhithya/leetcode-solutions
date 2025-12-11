class Solution {
    public String removeDuplicates(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);

            if(st.empty()){
                st.push(c);
            }else if(c==st.peek()){
                st.pop();
            }else{
                st.push(c);
            }
        }
        while(!st.empty()){
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
}