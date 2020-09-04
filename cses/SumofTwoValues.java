import java.io.*;
import java.util.Arrays;

public class SumofTwoValues {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    void run() throws IOException {
        int[] c = ni();
        int[] d = ni();
        int[][] data = new int[d.length][];
        for(int i = 0 ;i<d.length;i++){
            data[i] = new int[]{d[i],i};
        }
        Arrays.sort(data,(a,b) -> a[0] - b[0]);
        int i = 0;
        int j = d.length - 1;
        boolean found = false;
        while(i<j){
            int sum = data[i][0] + data[j][0];
            if(found = sum == c[1]) break;
            if(sum > c[1]) j--;
            else i++;
        }
        int a = Math.max( data[i][1] + 1,  data[j][1] + 1 );
        int b = Math.min( data[i][1] + 1,  data[j][1] + 1 );
        writer.println( found ? b +" "+ a : "IMPOSSIBLE");

    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        SumofTwoValues obj = new SumofTwoValues();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public SumofTwoValues(){
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


