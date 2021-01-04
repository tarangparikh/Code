import java.io.*;
public class Connected_Cells_in_a_Grid {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    void solve(int[][] d){
        int nc = 2;
        int max = Integer.MIN_VALUE;
        for(int i = 0,h=d.length;i<h;i++){
            for(int j = 0,v=d[0].length;j<v;j++){
                if(d[i][j] == 1){
                    max = Math.max(dfs(d,i,j,2),max);
                }
            }
        }
        System.out.println(max);
    }
    int dfs(int[][] d,int i,int j,int c){
        if(i<0||j<0||i>=d.length||j>=d[0].length||d[i][j] != 1) return 0;
        d[i][j] = c;
        int count = 1;
        count+=dfs(d,i-1,j-1,c);
        count+=dfs(d,i-1,j,c);
        count+=dfs(d,i-1,j+1,c);
        count+=dfs(d,i,j-1,c);
        count+=dfs(d,i,j+1,c);
        count+=dfs(d,i+1,j-1,c);
        count+=dfs(d,i+1,j,c);
        count+=dfs(d,i+1,j+1,c);
        return count;
    }

    void run() throws IOException {
        int n = getInt();
        int m = getInt();
        int[][] d = new int[n][];
        for(int i = 0,h=d.length;i<h;i++) d[i] = ints();
        solve(d);
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        Connected_Cells_in_a_Grid obj = new Connected_Cells_in_a_Grid();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public Connected_Cells_in_a_Grid(){
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


