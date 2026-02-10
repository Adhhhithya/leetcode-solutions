class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] s_map =new int[256];
        int[] t_map = new int[256];
        for(int i=0;i<s.length();i++){
            if(s_map[s.charAt(i)]!=t_map[t.charAt(i)]){
                return false;
            }
            s_map[s.charAt(i)] = i+1;
            t_map[t.charAt(i)] = i+1;
        }        
        return true;
    }
}