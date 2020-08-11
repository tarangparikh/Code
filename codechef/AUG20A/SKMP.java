import java.io.*;

class SKMP {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    String solve(String ss,String pp){
        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();

        int[] hash = make_hash(s,p);

        int st = p[0] - 'a';

        StringBuilder sb = new StringBuilder();
        for(int i = 0,h=st;i<=st;i++){
                for(int j = 0, l=hash[i] ;j<l;j++){
                sb.append((char)(i + 'a'));
            }
        }
        sb.append(p);
        for(int i = st + 1,h=hash.length;i<h;i++){
            for(int j = 0,l=hash[i] ;j<l;j++){
                sb.append((char)(i + 'a'));
            }
        }
        return sb.toString();
    }

    void make_hash(char[] a,char[] b){
        int[] hash = new int[26];
        for(char e : a) hash[e - 'a']++;
        for(char e : b) hash[e - 'a']--;
        return hash;
    }

    void run() throws IOException {
        int t = i();
        while(t-->0)sb.append(solve(bf.readLine().trim(),bf.readLine().trim())).append("\n");
        writer.println(sb.toString().trim());
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        SKMP obj = new SKMP();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public SKMP(){
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


