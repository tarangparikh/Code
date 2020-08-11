import java.io.*;

public class Introduction_to_Nim_Game {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    void run() throws IOException {
        int t = getInt();
        while(t-->0){
            getInt();
            int[] d = ints();
            int c = 0;
            for(int i = 0,h=d.length;i<h;i++) if(d[i] > 0) c++;
            if(c%2==0) sb.append("Second");
            else sb.append("First");
            sb.append("\n"); 
        }        
        writer.print(sb.toString().trim());
        
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        Introduction_to_Nim_Game obj = new Introduction_to_Nim_Game();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public Introduction_to_Nim_Game(){
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


