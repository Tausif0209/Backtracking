class PunishmentNumber {
    public int punishmentNumber(int n) {
          int i;
          int ans=0;
          for(i=1;i<=n;i++)
          {
            if(helper(i,0,i*i)) ans+=i*i;
          }
          return ans;
    }
    boolean helper(int n,int sum,int x)
    {
        if(x<10) return (sum+x==n);
        int p=(int)(Math.log(x)/Math.log(10));
        while(p>=0)
        {
            int den=(int)Math.pow(10,p--);
            if(helper(n,sum+(x/den),x%den)) 
            return true;
        }
           return false;
    }
}