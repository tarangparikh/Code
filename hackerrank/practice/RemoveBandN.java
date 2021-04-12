import java.io.*;
import java.util.ArrayDeque;

public class RemoveBandN {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;

    void run() throws IOException {
        String string = bf.readLine().trim();
        char[] e = string.toCharArray();
        ArrayDeque<Character> que = new ArrayDeque<>();
        int i = 0;
        int n = e.length;
        while(i<n){
            if(i+1 < n && e[i] == '\\' && e[i+1] == 'b'){
                if(que.size()>0) que.removeLast();
                i+=2;
                continue;
            }
                   
            if(i+1 < n && e[i] == '\\' && e[i+1] == 'n'){
                que.addLast('\n');
                i+=2;
                continue;
            }

            que.add(e[i++]);
            
        }
        for(char ee : que) sb.append(ee);
        System.out.println(sb.toString());

    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        RemoveBandN obj = new RemoveBandN();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public RemoveBandN(){
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


