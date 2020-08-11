import java.io.*;

public class Bear_and_Steady_Gene {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    int solve(String a){
        int n = a.length();
        char[] d = a.toCharArray();
        int[] hash = new int[4];
        for(int i = 0,h=d.length;i<h;i++) add(hash,d[i]);
        if(v(hash,n)) return 0;
        int min = n;
        int i = -1;
        int j = 0;
        remove(hash,d[0]);
        while(j<n-1){
            while(!v(hash,n)&&j<n-1) remove(hash,d[++j]); 
            if(j-i<min) min = j-i;
            add(hash,d[++i]);
        }
        while(v(hash,n)&&i<n-1){
            if(j-i<min) min = j-i;
            add(hash,d[++i]);
        }
        return min;
        
    }
    boolean v(int[] hash,int l){
        l>>=2;
        for(int i = 0,h=hash.length;i<h;i++)
            if((hash[i]) > l) return false;
        return true;
    }
    void add(int[] hash,char a){
        if(a=='A') hash[0]++;
        if(a=='T') hash[1]++;
        if(a=='C') hash[2]++;
        if(a=='G') hash[3]++;
    }
    void remove(int[] hash,char a){
        if(a=='A') if(hash[0]>0) hash[0]--;
        if(a=='T') if(hash[1]>0) hash[1]--;
        if(a=='C') if(hash[2]>0) hash[2]--;
        if(a=='G') if(hash[3]>0) hash[3]--;
    }

    void run() throws IOException {
        getInt();
        writer.println(solve(bf.readLine()));
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        Bear_and_Steady_Gene obj = new Bear_and_Steady_Gene();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public Bear_and_Steady_Gene(){
        writer = new PrintWriter(System.out);
        bf = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
    }

    public int getInt() throws IOException {
        return Integer.parseInt(bf.readLine().trim());
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


