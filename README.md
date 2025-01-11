# january11_2025
The problems that I solved today

1.Given a string s and an integer k, return true if you can use all the characters in s to construct k palindrome strings or false otherwise.

Code:
class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length()<k)
            return false;
        int[] freq=new int[26];
        int cnt=0;
        for(char c:s.toCharArray())
            freq[c-'a']++;
        for(int i:freq)
        {
            if(i%2==1)
                cnt++;
        }
        return cnt<=k;
    }
}

2.You are climbing a staircase. It takes n steps to reach the top. Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Code:
class Solution {
    public int climbStairs(int n) {
        if(n==1)    
            return n;
        int n1=1,n2=1,t=0,i;
        for(i=1;i<n;i++)
        {
            t=n1+n2;
            n1=n2;
            n2=t;
        }
        return t;
    }
}

3.You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night. Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Code:
class Solution {
    public int f(int ind,int[] nums,int[] dp)
    {
        if(ind<0)
            return 0;
        if(dp[ind]!=-1) 
            return dp[ind];
        int t=nums[ind]+f(ind-2,nums,dp);
        int nt=f(ind-1,nums,dp);
        return dp[ind]=Math.max(t,nt);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return f(n-1,nums,dp);
    }
}

4.Given an integer array nums, return the length of the longest strictly increasing subsequence.

Code:
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
