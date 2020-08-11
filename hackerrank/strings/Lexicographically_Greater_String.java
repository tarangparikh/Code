import java.io.*;
import java.util.Arrays;

public class Lexicographically_Greater_String {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    void run() throws IOException {
        int t = getInt();
        while(t-->0){
            String s = bf.readLine().trim();
            char[] d = s.toCharArray();
            int[] hash = new int[26];
            Arrays.fill(hash,-1);
            boolean f = false;
            for(int i = d.length -1 ;i>=0 ;i--){
                int j = lexoBig(hash,d[i]);
                if(j!=-1){
                    //System.out.println(i+" "+j);
                    char te = d[i];
                    d[i] = d[j];
                    d[j] = te;
                    Arrays.sort(d,i+1,d.length);
                    f = true;
                    sb.append(new String(d)).append("\n"); 
                    break;
                }
                hash[d[i] - 'a'] = i;
            }
            if(!f) sb.append("no answer").append("\n");
        }
        writer.append(sb.toString().trim());
    }

    int lexoBig(int[] hash,char a){
        for(int i = a - 'a' + 1 ; i < hash.length ; i++ ){
            if(hash[i]!=-1) return hash[i];
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        Lexicographically_Greater_String obj = new Lexicographically_Greater_String();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public Lexicographically_Greater_String(){
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

    public void close() throws IOException {
        writer.flush();
        writer.close();
        bf.close();
    }
}


