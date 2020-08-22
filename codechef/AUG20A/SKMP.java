import java.io.*;

class SKMP {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    /*
        cba
        bbccba
        bbccza
        bbczac
        
        
    */

    String solve(String ss,String pp){
        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();

        int[] hash = new int[26];
        for(char e : s) hash[e - 'a']++;
        for(char e : p) hash[e - 'a']--;

        if(nextSmall(p)){
            StringBuilder sb = new StringBuilder();
            for(int i = 0,h=p[0] - 'a';i<h;i++){
                for(int j = 0,l=hash[i];j<l;j++){
                    sb.append((char)(i+'a'));
                }
            }
            sb.append(p);
            for(int i = p[0] - 'a',h = hash.length;i<h;i++){
                for(int j = 0,l=hash[i];j<l;j++){
                    sb.append((char)(i+'a'));
                }
            }
            return sb.toString().trim();
        }else{
            StringBuilder sb = new StringBuilder();
            for(int i = 0,h=p[0] - 'a';i<=h;i++){
                for(int j = 0,l=hash[i];j<l;j++){
                    sb.append((char)(i+'a'));
                }
            }
            sb.append(p);
            for(int i = p[0] - 'a' + 1,h = hash.length;i<h;i++){
                for(int j = 0,l=hash[i];j<l;j++){
                    sb.append((char)(i+'a'));
                }
            }
            return sb.toString().trim();
        }
    }

    boolean nextSmall(char[] d){
        int i = 1;
        int n = d.length;
        while(i<n&&d[i]==d[i-1]) i++;
        return i<n&&d[i]<=d[i-1];
    }

   

    void run() throws IOException {
        int t = i();
        while(t-->0)sb.append(solve(bf.readLine().trim(),bf.readLine().trim())).append("\n");
        writer.print(sb.toString().trim());
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


