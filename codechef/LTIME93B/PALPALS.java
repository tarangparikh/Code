import java.io.*;

class PALPALS {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    void run() throws IOException {
        int t = i();
        while(t-->0){
            char[] d = bf.readLine().trim().toCharArray();
            int[] h = new int[26];
            for(char e : d) h[e-'a']++;
            int oo=0,ee=0;
            for(int e : h) 
                if(e > 0){
                    ee+=e>>1;
                    oo+=(e&1)==1?1:0;
                }
            sb.append(oo <= ee ? "YES\n" : "NO\n");
        }
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        PALPALS obj = new PALPALS();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public PALPALS(){
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


