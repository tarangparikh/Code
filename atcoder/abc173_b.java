import java.io.*;

class Main {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    void run() throws IOException {
        int t = getInt();
        int[] h = new int[4];
        while(t-->0) add(bf.readLine().trim(),h);
        writer.println(get(h));
    }

    void add(String s,int[] h){
        if(s.equals("AC")) h[0]++;
        else if(s.equals("WA")) h[1]++;
        else if(s.equals("TLE")) h[2]++;
        else if(s.equals("RE")) h[3]++;
    }
    String get(int[] h){
        StringBuilder sb = new StringBuilder();
        sb.append("AC x "+h[0]).append("\n");
        sb.append("WA x "+h[1]).append("\n");
        sb.append("TLE x "+h[2]).append("\n");
        sb.append("RE x "+h[3]).append("\n");
        return sb.toString().trim();
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


