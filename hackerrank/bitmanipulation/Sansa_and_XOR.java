import java.io.*;

public class Sansa_and_XOR {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    void run() throws IOException {
        int t = i();
        while(t-->0){
            i(); int[] d = ni();
            if(d.length % 2 == 0){
                writer.println(0);
                continue;
            }
            int i = d.length - 1;
            long xor = 0l;
            while(i>=0){
                xor ^= d[i];
                i-=2;
            }
            writer.println(xor);
        }
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        Sansa_and_XOR obj = new Sansa_and_XOR();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public Sansa_and_XOR(){
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


