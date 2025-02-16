class Solution {
    public int[] constructDistancedSequence(int n) {
    if(n==1) return new int[]{1};
    int[] ans=new int[(2*n)-1];
    boolean[] isPresent=new boolean[n+1];
    backTracking(ans,0,isPresent,n,(2*n-1));
    return ans;
    }
     static boolean backTracking(int[] ans,int i,boolean[] isPresent,int n,int len) {
        if (i == len) return true;
        if(ans[i]!=0) return backTracking(ans,i+1,isPresent,n,len);
        for (int j = n; j >= 1; j--) {
            if(isPresent[j]||(j!=1&&(i+j>=len||ans[i+j]!=0))) continue;
            ans[i]=j;
            if(j!=1) ans[i+j]=j;
            isPresent[j]=true;
            boolean result=backTracking(ans,i+1,isPresent,n,len);
            if(result) return true;
            ans[i]=0;
            if(j!=1) ans[i+j]=0;
            isPresent[j]=false;
        }
        return false;
     }
}