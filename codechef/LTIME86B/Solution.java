import java.io.*;

public class Solution {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    void run() throws IOException {
        int t = getInt();
        int[] data = new int[100005];
        while(t-->0){
            String[] d = bf.readLine().trim().split(",");
            int s = convert(d[1]);
            int e = convert(d[2]);
            data[s]++;
            data[e+1]--;
        }
        for(int i = 1,h=data.length;i<h;i++)
            data[i] += data[i-1];
        String time = bf.readLine().trim();
        int int_time = convert(time);
        writer.println(data[int_time]);
    }
    int convert(String t){
        String[] d = t.split(":");
        int hh = Integer.parseInt(d[0]);
        int mm = Integer.parseInt(d[1]);
        int ss = Integer.parseInt(d[2]);
        int time = hh*60*60 + mm*60 + ss;
        return time;
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        Solution obj = new Solution();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public Solution(){
        writer = new PrintWriter(System.out);
        bf = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
    }

    public int getInt() throws IOException {
        return Integer.parseInt(bf.readLine());
    }

    public long getLong() throws IOException {
        return Long.parseLong(bf.readLine());
    }

    public int[] ints() throws IOException {
        String[] data = bf.readLine().split(" ");
        int[] send = new int[data.length];
        for (int i = 0, h = data.length; i < h; i++) send[i] = Integer.parseInt(data[i]);
        return send;
    }

    public long[] longs() throws IOException {
        String[] data = bf.readLine().split(" ");
        long[] send = new long[data.length];
        for (int i = 0, h = data.length; i < h; i++) send[i] = Long.parseLong(data[i]);
        return send;
    }

    public void close() {
        writer.flush();
        writer.close();
    }
}


