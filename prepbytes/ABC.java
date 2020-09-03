import java.io.*;

public class ABC {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    boolean isValid(int[] hash){
        for(int i = 0,h=hash.length ;i<h;i++){
            if(hash[i] == 0) return false;
        }
        return true;
    }
    void add(int[] hash,char a){
        if(a=='a') hash[0]++;
        if(a=='c') hash[2]++;
        if(a=='b') hash[1]++;
    }

    void remove(int[] hash,char a){
        if(a=='a') hash[0]--;
        if(a=='c') hash[2]--;
        if(a=='b') hash[1]--;
    }

    void solve(String s){
        char[] d = s.toCharArray();
        int[] hash = new int[3];
        int i = -1;
        int j = 0;
        int jlen = d.length;
        int min = Integer.MAX_VALUE;
        add(hash,d[0]);
        while(j < jlen){
            if(isValid(hash)){
                min = Math.min(j - i,min);
                remove(hash,d[++i]);
            }else{
                ++j;
                if( j < jlen) add(hash,d[j]);
            }
        }
        while( i < jlen){
            if(isValid(hash)){
                min = Math.min(min, jlen - i);
            }
            ++i;
            if( i < jlen) remove(hash,d[i]);
        }
        writer.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    void run() throws IOException {
        int t = i();
        while(t-->0){
            solve(bf.readLine().trim());
        }
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        ABC obj = new ABC();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public ABC(){
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


