import java.io.*;
import java.util.Arrays;

public class _2160C {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    void run() throws IOException {
        int t = getInt();
        while (t-- > 0) {
            int n = getInt();
            int array_size = 64;
            int[] dp = new int[array_size];
            int k = array_size - 1;
            int temp = n;
            int size = temp == 0 ? 1 : 0;
            while (temp > 0) {
                dp[k--] = temp % 2;
                temp /= 2;
                size++;
            }
//            System.out.println(size);
//            System.out.println(Arrays.toString(dp));
            int start = array_size - size ;
//            System.out.println(start);
            boolean found = false;
            for(int i = start;i>=start-size+1;i--){
                if(isValid(dp, i, array_size - 1)){
                    found = true;
                    break;
                }
            }
            if(found){
                writer.println("YES");
            }else{
                writer.println("NO");
            }
        }
    }
    boolean isValid(int[] dp, int i, int j) {
        while(i <= j) {
            if (i == j && dp[i] == 1) return false;
            else if (dp[i] != dp[j]) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        _2160C obj = new _2160C();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public _2160C(){
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


