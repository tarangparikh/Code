import java.io.*;
import java.util.Arrays;

public class Triangle {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;

    public int longest(int[] data) {
        Arrays.sort(data);
        int n = data.length;
        int max = Math.min(data.length, 0);
        for (int i = 2; i < n; i++) {
            int ind = Arrays.binarySearch(data,i,data.length,data[i-1] + data[i-2]);
            if(ind < 0) ind = - (ind + 1) - 1;
            if (ind - i + 3 > max) {
                max = ind - i + 3;
            }
        }
        return max;
    }
    public int[] get(int[] d){
        Arrays.sort(d);
        while(t-->0)

        return null;
    }

    int solve(int[] d){
        int n = d.length;
        int[][] data = new int[n][];
        for(int i = 0;i<n;i++){
            data[i] = new int[]{d[i],i};
        }
        Arrays.sort(data,(a,b)->{
            if(a[0]==b[0]) return Integer.compare(a[1],b[1]);
            else return Integer.compare(a[0],b[0]);
        });

        int[] dp = new int[n];
        int[] bit = new int[n+5];
        int max = 0;
        for(int i = 0,h=data.length;i<h;i++){
            update(bit,data[i][1],1);
            dp[i] = query(bit,data[i][1]);
            max = Math.max(dp[i],max);
        }
        return max;
    }

    int query(int[] d,int i){
        int s = 0; for(++i ; i>0 ; s+=d[i], i-=i&-i); return s; 
    }
    void update(int[] d,int i,int v){
        int n = d.length; for(++i ; i<n ; d[i]+=v, i+=i&-i);
    }
    
    void run() throws IOException {
        int n = i();

        int[] d = ni();
        writer.println(longest(d));

    }

   

    public static void main(String[] args) throws IOException {
        Triangle obj = new Triangle();
        obj.run();
        obj.close();
    }

    public Triangle(){
        writer = new PrintWriter(System.out);
        bf = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
    }

    public int i() throws IOException {
        return Integer.parseInt(bf.readLine());
    }

    public int[] ni() throws IOException {
        String[] data = bf.readLine().split(" ");
        int[] send = new int[data.length];
        for (int i = 0, h = data.length; i < h; i++) send[i] = Integer.parseInt(data[i]);
        return send;
    }

    public void close() throws IOException{
        writer.flush();
        writer.close();
        bf.close();
    }
}


