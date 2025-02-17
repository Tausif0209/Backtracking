class Solution {
    public int numTilePossibilities(String tiles) {
        int len=tiles.length();
        if(len==1) return 1;
        HashSet<String> set=new HashSet<>();
        subsequences("",tiles,set);
        HashSet<String> ans=new HashSet<>();
        for(String s:set)
        {
            permutation("",s,ans);
        }
        return ans.size();

    }
    void subsequences(String p,String up,HashSet<String> set)
    {
        if(up.isEmpty())
        {
           if(!p.isEmpty()) set.add(p);
           return ;
        }
        subsequences(p+up.charAt(0),up.substring(1),set);
        subsequences(p,up.substring(1),set);
    }
    void permutation(String p,String up,HashSet<String> set)
    {
       if(up.isEmpty())
        {
           set.add(p);
           return ;
        }
        int len=p.length();
        for(int i=0;i<=len;i++)
        {
            permutation(p.substring(0,i)+up.charAt(0)+p.substring(i),up.substring(1),set);
        }
    }
}