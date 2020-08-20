import java.io.*;

public class Sum_Of_Four_Values {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;

    void run() throws IOException {
        int[] c = ni();
        int[] d = ni();
        Arrays.sort(d);
        long[][] dp = new long[(d.length - 1)*(d.length)>>1][3];
        for(int i = 0,k=0,h=d.length;i<h;i++){
            for(int j = i+1;j<h;j++){
                dp[k][0] = (long)d[i]*(long)d[j];
                dp[k][1] = i;
                dp[k][]
            }
        }
        int i = 0;
        int j = dp.length - 1;
        boolean found = false;
        while(i<j){
            long sum = dp[i] + dp[j];
            if(found = sum==c[1]) break;
            if(sum>c[1]) i++;
            else j--;
        }

    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        Sum_Of_Four_Values obj = new Sum_Of_Four_Values();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public Sum_Of_Four_Values(){
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


