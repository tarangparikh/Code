import java.io.*;

import javax.sound.midi.Soundbank;

class AVGSORT {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;

    void run() throws IOException {
        int t = i();
        while(t-->0){
            int n = i();
            int[] d = ni();
            int m = d[n-1];
            boolean NP = false;
            for(int i = 0;i<n-1;i++)
                if(NP = d[i] >= m) break;
            sb.append(NP ? "NO\n" : "YES\n");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        AVGSORT obj = new AVGSORT();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public AVGSORT(){
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


