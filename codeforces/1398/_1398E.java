import java.io.*;
import java.util.TreeMap;

public class _1398E {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;

    void run() throws IOException {
        int t = i();
        TreeMap<Integer,Integer> dp = new TreeMap<>();
        long first = 0;
        long second = 0;
        while(t-->0){
            int[] c = ni();
            if(c[0]==0){
                if(c[1]<0) first -= -c[1];
                else first += c[1];
            }else{
                if(c[1]<0){
                    int q = dp.get(-c[1]);
                    if(q==1) dp.remove(-c[1]);
                    else dp.put(-c[1], q-1);
                    second -= -c[1];
                }else{
                    dp.put(c[1], dp.getOrDefault(c[1], 0)+1);
                    second += c[1];
                }
            }

            long s = 0;
            if(dp.size() > 0) s += (first << 1);
            else s += first;

            writer.println(first+" "+second);

            s += (second<<1) - dp.size() > 0 ? dp.firstKey() : 0;
            
            writer.println(s);
        }
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        _1398E obj = new _1398E();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public _1398E(){
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


