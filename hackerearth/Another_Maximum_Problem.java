import java.io.*;
import java.util.*;

public class Another_Maximum_Problem {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    void solve(int[] d,int[] q){
        var s = new int[100005];
        var ng = new int[d.length];
        var pg = new int[d.length];

        Arrays.fill(ng,d.length);
        Arrays.fill(pg,-1);

        var t = -1;
        for(int i = 0,h=d.length;i<h;i++){
            while(t!=-1&&d[s[t]]<d[i])
                ng[s[t--]] = i;
            s[++t] = i;
        }
        
        t=-1;
        for(int i = d.length-1;i>=0;i--){
            while(t!=-1&&d[s[t]]<=d[i])
                pg[s[t--]] = i;
            s[++t] = i;
        }
        
        var dp = new HashMap<Integer,Long>();
        
        for(int i = 0,h=d.length;i<h;i++){
            long a = (long)(ng[i] - i) * (long)(i-pg[i]);
            dp.put(d[i],dp.getOrDefault(d[i],0L)+a);
        }
        
        for(int e : q)
            sb.append(dp.getOrDefault(e,0l)).append("\n");
        
        writer.println(sb.toString().trim());
    }

    void run() throws IOException {
        i(); int[] d = ni();
        i(); int[] q = ni();
        solve(d,q);
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        Another_Maximum_Problem obj = new Another_Maximum_Problem();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public Another_Maximum_Problem(){
        writer = new PrintWriter(System.out);
        bf = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
    }

    public int i() throws IOException {
        return Integer.parseInt(bf.readLine());
    }

    public int[] ni() throws IOException {
        String[] data = bf.readLine().split(" ");
        int[] send = new int[data.length];
        for (int i = 0, h = data.length; i < h; i++) send[i] = Integer.parseInt(data[i]);
        return send;
    }
    
    public void close() throws IOException{
        writer.flush();
        writer.close();
        bf.close();
    }
}


