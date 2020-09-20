import java.io.*;
import java.util.Arrays;

public class IncreasingSubsequence {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;

    void run() throws IOException {
        int n = i();
        int[][] d = new int[n][];
        for(int i = 0;i<n;i++){
            d[i] = new int[]{Integer.parseInt(bf.readLine().trim()), i};
        }
        Arrays.sort(d,(a,b) -> a[0] - b[0]);
        
    }

    class ST {
        int size;
        public int[] data;
        public ST(int size){
            this.size = size;
            this.data = new int[size<<1];
        }
        void build(){
            for(int i = size;i>0;i--){
                this.data[i] = this.data[i<<1] + this.data[i<<1|1];
            }
        }
        public void build(int[] data){
            int size = data.length>>1;
            for(int i = size-1;i>0;i--){
                data[i] = data[i<<1] + data[i<<1|1];
            }
        }
        public void modify(int index,int value){
            for(this.data[index+=size] = value;index>1;index>>=1){
                this.data[index>>1] = this.data[index] + this.data[index^1];
            }
        }
        public int query(int l,int r){
            int res = 0;
            for(l+=size,r+=size;l<r;l>>=1,r>>=1){
                if((l&1)==1) res+=this.data[l++];
                if((r&1)==1) res+=this.data[--r];
            }
            return res;
        }
        public int[] min(int[] a,int[] b){
            return a[0] <= b[0] ? a : b;
        }
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        IncreasingSubsequence obj = new IncreasingSubsequence();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public IncreasingSubsequence(){
        writer = new PrintWriter(System.out);
        bf = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
    }

    public int i() throws IOException {
        return Integer.parseInt(bf.readLine());
    }

    public long l() throws IOException {
        return Long.parseLong(bf.readLine());
    }

    public int[] ni() throws IOException {
        String[] data = bf.readLine().split(" ");
        int[] send = new int[data.length];
        for (int i = 0, h = data.length; i < h; i++) send[i] = Integer.parseInt(data[i]);
        return send;
    }

    public long[] nl() throws IOException {
        String[] data = bf.readLine().split(" ");
        long[] send = new long[data.length];
        for (int i = 0, h = data.length; i < h; i++) send[i] = Long.parseLong(data[i]);
        return send;
    }

    public void close() throws IOException{
        writer.flush();
        writer.close();
        bf.close();
    }
}


