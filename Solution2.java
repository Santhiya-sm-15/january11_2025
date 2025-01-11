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