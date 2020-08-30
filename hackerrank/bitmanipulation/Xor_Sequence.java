import java.io.*;

public class Xor_Sequence {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;

    long solve(long a){
        long p = 1;
        long n = 0;
        for(int i = 0;i<60;i++,p<<=1){
            long aa =p == 1 ? a : (a - a%p + p) / p;
            if(aa%2==0) n += p;
            //writer.println(n+" "+aa);
        }
        return n;
    }

    void run() throws IOException {
        writer.println(solve(3L));
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        Xor_Sequence obj = new Xor_Sequence();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public Xor_Sequence(){
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


