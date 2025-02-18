class Solution {
    public String smallestNumber(String pattern) {
        boolean[] isPresent=new boolean[10];
        int[] num=new int[pattern.length()+1];
        helper(num,isPresent,-1,pattern);
        StringBuilder sb=new StringBuilder();
        for(int el:num)
        {
            sb.append(el);
        }
        return sb.toString();
    }
    boolean helper(int[] num,boolean[] isPresent,int i,String pattern)
    {
        if(i==pattern.length()) return true;
        int j;
        if(i==-1) {
            for( j=1;j<=9;j++)
            {
                num[0]=j;
                isPresent[j]=true;
                if(helper(num,isPresent,i+1,pattern)) return true;
                num[0]=0;
                isPresent[j]=false;
            }
        }
        else if(pattern.charAt(i)=='I'){
            for(j=num[i]+1;j<=9;j++)
            {
                if(isPresent[j]) continue;
                isPresent[j]=true;
                num[i+1]=j;
                 if(helper(num,isPresent,i+1,pattern)) return true;
                num[i+1]=0;
                isPresent[j]=false;
            }
        }
        else{
            for(j=1;j<num[i];j++)
            {
                if(isPresent[j]) continue;
                isPresent[j]=true;
                num[i+1]=j;
                 if(helper(num,isPresent,i+1,pattern)) return true;
                num[i+1]=0;
                isPresent[j]=false;
            }
        }
        return false;
    }
}