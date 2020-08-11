import java.io.*;

class MAXOR {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    long solve(int[] d){
        long c = 0;
        for(int i = 0,h=d.length;i<h;i++){
            for(int j = i+1;j<h;j++){
                if((d[i]&d[j]) == d[i]) c++;
                else if((d[i]&d[j]) == d[j]) c++;
            }
        }
        return c;
    }
    long solve1(int[] d){
        int[] h = new int[1000001];
        for(int i = 0,l = d.length;i<l;i++) h[d[i]]++;
        long count = 0;
        for(int i = 0,l=d.length;i<l;i++){
            for(int j = d[i];j>0;j = d[i] & (j-1)){
                if(j!=d[i])
                count += h[j];
            }
        }
        for(int e : h) count += (e*(e-1))>>1;
        return count;
    }
    

    void run() throws IOException {
        int t = i();
        while(t-->0){
            i(); int[] d = ni();
            sb.append(solve1(d)).append("\n");
        }
        writer.println(sb.toString().trim());
        

    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        MAXOR obj = new MAXOR();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public MAXOR(){
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

    public void close() throws IOException {
        writer.flush();
        writer.close();
        bf.close();
    }
}


