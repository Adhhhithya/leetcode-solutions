1class Solution {
2    public List<List<Integer>> combinationSum3(int k, int n) {
3        List<List<Integer>> ans = new ArrayList<>();
4        List<Integer> list = new ArrayList<>();
5        solve(n,list,ans,k);
6        return ans;
7    }
8    private static void solve(
9        int sum,
10        List<Integer> list,
11        List<List<Integer>> ans,
12        int k
13    ){
14        if(sum==0 && list.size()==k){
15            ans.add(new ArrayList<>(list));
16            return;
17        }
18        if(sum<0 ||list.size()>k){
19            return;
20        }
21        int element = list.isEmpty() ? 1:list.get(list.size()-1) +1;
22        for(int i=element;i<=9;i++){
23            if(i<=sum){
24                list.add(i);
25                solve(sum-i,list,ans,k);
26                list.remove(list.size()-1);
27            }
28        }
29    }
30}