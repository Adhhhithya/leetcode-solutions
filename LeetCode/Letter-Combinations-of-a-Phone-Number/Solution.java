1class Solution {
2    private String[] map;;
3    public Solution(){
4        map = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
5    }
6    public List<String> letterCombinations(String digits) {
7        List<String> ans = new ArrayList<>();
8        if(digits.length()==0) return ans;
9        solve(0,digits,ans,"");
10        return ans;
11    }
12    private void solve(
13        int ind,
14        String digits,
15        List<String> ans,
16        String curr
17    ){
18        if(ind==digits.length()){
19            ans.add(curr);
20            return;
21        }
22        String s = map[digits.charAt(ind)-'0'];
23        for(int i=0;i<s.length();i++){
24            solve(ind+1,digits,ans,curr+s.charAt(i));
25        }
26    }
27}