import java.util.*;
import java.io.*;
public class App{
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter writer = new PrintWriter(System.out);
    private static void close() throws IOException{
        bf.close();
        writer.flush();
        writer.close();
    }
    private int i() throws IOException { return Integer.parseInt(bf.readLine()); }
    private int[] ni() throws IOException {
        String[] s = bf.readLine().split(" ");
        int[] d = new int[s.length];
        for(int i=0, h=d.length; i<h; i++)
            d[i] = Integer.parseInt(s[i]);
        return d;
    }
    public static void main(String...args) throws IOException{
        
        close();
    }
}