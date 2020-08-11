import java.io.*;

class Main {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    void run() throws IOException {
        long t = getLong();
        StringBuilder sb = new StringBuilder();
        while(t>0){
            char d  = t%26 == 0 ? (char)'z' : (char)((t%26) + 'a' - 1);
            sb.append(d);
            t/=26;
        }
        char[] d = sb.toString().toCharArray();
        int i = 0;
        int j = d.length-1;
        while(i<j){
            char tt = d[i];
            d[i] = d[j];
            d[j] = tt;
            i++;
            j--;
        }
        writer.println(new String(d));
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        Main obj = new Main();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public Main(){
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

    public void close() throws IOException{
        writer.flush();
        writer.close();
        bf.close();
    }
}


