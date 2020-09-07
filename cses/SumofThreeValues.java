import java.io.*;
import java.util.Arrays;

public class SumofThreeValues {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;
    
    int[] check(int[] d,int i,int v){
        int j = d.length - 1;
        while(i<j){
            int sum = d[i] + d[j];
            if(sum == v) return new int[]{i,j};
            else if(sum > v) j--;
            else i++;
        }
        return new int[]{-1};
    }
    int[] check2(int[] d,int v){
        for(int i = 0,h=d.length - 2;i<h;i++){
            int r = v - d[i];
            if(r < 2) break;
            int[] check = check(d,i + 1,r);
            if(check[0] != -1) return new int[]{i,check[0],check[1]};
        }
        return new int[]{-1};
    }

    void run() throws IOException {
        int[] c = ni();
        int n = c[0];
        int v = c[1];
        int[] d = ni();
        int[][] data = new int[n][];
        for(int i = 0;i<n;i++) data[i] = new int[]{d[i],i};
        Arrays.sort(data , (a,b) -> a[0] - b[0]);
        Arrays.sort(d);
        int[] check = check2(d, v);
        if(check[0] == -1) writer.println("IMPOSSIBLE");
        else{
            int a = data[check[0]][1] + 1;
            int b = data[check[1]][1] + 1;
            int cd = data[check[2]][1] + 1;
            writer.println(a +" "+b+" "+cd);
        }
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        SumofThreeValues obj = new SumofThreeValues();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public SumofThreeValues(){
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


