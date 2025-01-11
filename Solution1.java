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