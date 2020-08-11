import java.io.*;
import java.util.Arrays;

class MAXAND18 {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;

    String solve(int[] d,int k){
        long[][] bits = new long[31][2];
        for(int i = 0,h=bits.length;i<h;i++){
            bits[i][1] = i;
        }
        for(int i = 0,h=d.length;i<h;i++){
            int temp = d[i];
            for(int j = 0;j<30&&temp>0;j++){
                if(temp%2==1) bits[j][0]++;
                temp>>=1;
            }
        }
        int n = 1;
        for(int i = 0,h=bits.length;i<h;i++){
            bits[i][0]*=n;
            n<<=1;
        }
        Arrays.sort(bits,(o1, o2) -> Long.compare(o2[0],o1[0]));
        int[] bit_map = new int[31];
        int count = k;
        for(int i = 0,h=bits.length;i<h&&count>0;i++){
            bit_map[(int)bits[i][1]] = 1;
            count--;
        }
        long number = 0;
        for(int i = bit_map.length-1;i>=0;i--){
            number<<=1;
            number+=bit_map[i];
        }
        return Long.toString(number);
    }

    void run() throws IOException {
        int t = i();
        while (t-->0){
            int[] c = ni();
            int[] d = ni();
            sb.append(solve(d,c[1])).append("\n");
        }
        writer.println(sb.toString().trim());
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        MAXAND18 obj = new MAXAND18();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public MAXAND18(){
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

    public void close() {
        writer.flush();
        writer.close();
    }
}


