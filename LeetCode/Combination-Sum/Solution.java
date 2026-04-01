1class Solution {
2    public List<List<Integer>> combinationSum(int[] candidates, int target) {
3        int n = candidates.length;
4        List<List<Integer>> ans = new ArrayList<>();
5        List<Integer> list = new ArrayList<>();
6        solve(0,list,ans,candidates,target,n);
7        return ans;
8    }
9
10    private static void solve(
11        int ind,
12        List<Integer> list,
13        List<List<Integer>> ans,
14        int[] arr,
15        int sum,
16        int n){
17            if(sum==0){
18                ans.add(new ArrayList<>(list));
19                return;
20            }
21            if(ind==n || sum<0){
22                return;
23            }
24            list.add(arr[ind]);
25            solve(ind,list,ans,arr,sum-arr[ind],n);
26            list.remove(list.size()-1);
27            solve(ind+1,list,ans,arr,sum,n);
28        }
29}