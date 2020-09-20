import java.io.*;

public class _5494 {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;

    int ways(int[] d,int start,int end,int f){
        if(start == end) return 1 + ways(d, start, end, f);
        int count = 0;
        for(int i = 0,h=d.length;i<h;i++){
            
            if(i!=start){
                if(Math.abs(d[i] - d[start]) <= f){
                    count += ways(d,i,end,f - Math.abs(d[i] - d[start]));
                }
            }
        }
        return count;
    }

    void run() throws IOException {
        int[] d = new int[]{4,3,1};
        writer.println(ways(d,2,0,3));
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        _5494 obj = new _5494();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public _5494(){
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


