import java.io.*;

class ASTRING {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    static char[] s = new char[100005];

    String solve(String a,int n){
        int t = -1;
        int k = a.length() - n;
        for(int i = 0,h=a.length();i<h;i++){
            if(t!=-1) while( t!=-1 && s[t]>a.charAt(i) && k>0 ) {--t; --k;}
            s[++t] = a.charAt(i);
        }
        while(t>n-1) --t;
        char[] r = new char[n];
        System.arraycopy(s, 0, r, 0, r.length);
    }

    void run() throws IOException {
        int t = i();
        while(t-->0) {
            String s = bf.readLine();
            int n = i();
            sb.append(solve(s,n)).append("\n");
        }
        writer.println(sb.toString().trim());
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        ASTRING obj = new ASTRING();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public ASTRING(){
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

    public void close() throws IOException {
        writer.flush();
        writer.close();
        bf.close();
    }
}