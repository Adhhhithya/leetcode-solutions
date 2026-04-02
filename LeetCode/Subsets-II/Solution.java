1class Solution {
2    public List<List<Integer>> subsetsWithDup(int[] nums) {
3        int n = nums.length;
4        List<List<Integer>> ans = new ArrayList<>();
5        List<Integer> list = new ArrayList<>();
6        Arrays.sort(nums);
7        solve(0,list,ans,nums,n);
8        return ans;
9    }
10    private static void solve(
11        int ind,
12        List<Integer> list,
13        List<List<Integer>> ans,
14        int [] arr,
15        int n
16    ){
17        if(ind==n){
18            ans.add(new ArrayList<>(list));
19            return;
20        }
21        list.add(arr[ind]);
22        solve(ind+1,list,ans,arr,n);
23        list.remove(list.size()-1);
24        for(int i=ind+1;i<n;i++){
25            if(arr[i]!=arr[ind]){
26                solve(i,list,ans,arr,n);
27                return;
28            }
29        }
30        solve(n,list,ans,arr,n);
31    }
32}