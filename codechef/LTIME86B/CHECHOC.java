import java.io.*;

class CHECHOC {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    void solve(long[] c){
        if(c[0]*c[1] == 1){
            sb.append(c[2]).append("\n");
            return;
        }
        c[2] = Math.min(c[2],c[3]);
        c[3] = Math.min(2*c[2],c[3]);
        long l = c[2];
        long s = c[3] - c[2];
        long ss = c[0] * c[1];
        long d = (c[0] * c[1])>>1;
        long f = ((ss+1)>>1)*l+(ss>>1)*(s);
        sb.append(f).append("\n");
    }

    void run() throws IOException {
        int t = getInt();
        while(t-->0){
            long[] c = longs();
            solve(c);
        }
        writer.println(sb.toString().trim());
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        CHECHOC obj = new CHECHOC();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public CHECHOC(){
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