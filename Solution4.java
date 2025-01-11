class Solution {
    public int lengthOfLIS(int[] nums) {
        int i,j,n=nums.length,max=0;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        for(i=0;i<n;i++)
        {
            for(j=0;j<i;j++)
            {
                if(nums[j]<nums[i])
                    dp[i]=Math.max(dp[i],1+dp[j]);
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}