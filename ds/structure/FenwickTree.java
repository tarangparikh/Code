/**
    Note: Add buffer of 2-5 index for usage
 */
 public class FenwickTree{
    
    static int query(int[] d,int i){
        int s = 0; for(++i;i>0;s+=d[i],i-=i&-i); return s;
    }

    static void update(int[] d,int i,int v){
        int n = d.length; for(++i;i<n;d[i]+=v,i+=i&-i);
    }

}