import java.io.*;
import java.util.ArrayList;

public class _1398B {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    void solve() throws IOException{ 
        char[] d = bf.readLine().trim().toCharArray();
        ArrayList<Integer> list = new ArrayList<>();
        int prev = 0;
        for(char e : d){
            if(e=='0'){
                if(prev!=0) list.add(prev);
                prev = 0;
            }else prev++;
        }
        if(prev!=0) list.add(prev);
        int count = 0;
        list.sort((a,b) ->  b-a);
        for(int i = 0,h=list.size();i<h;i+=2)
            count+=list.get(i);
        writer.println(count);
    }
    

    void run() throws IOException {
        int t = i();
        while(t-->0){
            solve();
        }
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        _1398B obj = new _1398B();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public _1398B(){
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


