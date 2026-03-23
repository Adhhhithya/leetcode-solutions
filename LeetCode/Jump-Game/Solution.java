1class Solution {
2    public boolean canJump(int[] nums) {
3        int maxInd =0;
4        int n = nums.length;
5        for(int i=0;i<n;i++){
6            if (i>maxInd)  return false;
7            maxInd = Math.max(maxInd,i+nums[i]);
8        }
9        return true;
10    }
11}