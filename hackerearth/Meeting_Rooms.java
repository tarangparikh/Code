import java.io.*;

public class Meeting_Rooms {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    void run() throws IOException {
        int n = i();
        int[] e = new int[2405];
            
        while(n-->0){
            String[] d = bf.readLine().trim().split(" ");
            int a = Integer.parseInt(d[0] + d[1]);
            int b = Integer.parseInt(d[2] + d[3]);
            e[a]++;
            e[b+1]--;
        }

        int max = 0;
        for(int i = 1,h=e.length;i<h;i++){
            e[i]+=e[i-1];
            max = Math.max(e[i],max);
        }
        writer.println(max);
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        Meeting_Rooms obj = new Meeting_Rooms();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public Meeting_Rooms(){
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


