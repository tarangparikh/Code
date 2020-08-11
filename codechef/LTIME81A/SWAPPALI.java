import java.io.*;
import java.util.Arrays;

class SWAPPALI {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    String solve(String a){
        if(a.length() == 1){
            return "YES\n0";
        }
        char[] d = a.toCharArray();
        int c = 0;
        int i = 0;
        int j = d.length - 1;
        for(;j-i>2;){
            if(d[i]==d[j]){
                i++;
                j--;
            }else{
                if(d[i+1]!=d[j]||d[j-1]!=d[i]) return "NO";
                swap(d,i,i+1);
                c++;
                i+=2;
                j-=2;
            }
        }
        if(isP(d, i, j)){
            if(!isPP(d,i,j)) c++;
            return "YES\n"+c; 
        }else{
            return "NO";
        }
        
    }

    boolean isPP(char[] d,int a,int b){
        while(a<b){
            if(d[a]!=d[b]) return false;
            a++;
            b--;
        }
        return true;
    }

    boolean isP(char[] d,int a,int b){
        int[] hash = new int[26];
        for(int i = a;i<=b;i++){
            hash[d[i]-'a']++;
        }
        int c = 0;
        for(int i = 0;i<hash.length;i++){
            if(hash[i]%2==1) c++;
            if(c>1) return false;
        }
        return true;

    }

    void swap(char[] d,int i,int j){
        char t = d[i];
        d[i] = d[j];
        d[j] = t;
    }

    void run() throws IOException {
        int t = getInt();
        while(t-->0){
            getInt();
            sb.append(solve(bf.readLine())).append("\n");
        }
        writer.println(sb.toString().trim());
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        SWAPPALI obj = new SWAPPALI();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public SWAPPALI(){
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

    public void close() throws IOException {
        writer.flush();
        writer.close();
        bf.close();
    }
}


