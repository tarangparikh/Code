public class FI {
    private final long[][] data;
    private final long mod;
    public FI(int size,long mod){
        this.mod = mod;
        this.data = new long[size+1][2];
        make();
    }

    public long[][] getData() {
        return data;
    }

    private void make(){
        this.data[0][0] = 1;
        this.data[0][1] = 1;
        for(int i = 1,h=this.data.length;i<h;i++){
            this.data[i][0] = ((long)i * this.data[i-1][0])%this.mod;
            this.data[i][1] = power(this.data[i][0],this.mod-2,this.mod);
        }
    }
    private long power(long a,long b,long mod){
        long p = 1L;
        for(;b>0;b>>=1,a=a*a%mod)
            if ((b&1)==1) p=p*a%mod;
        return p;
    }

}