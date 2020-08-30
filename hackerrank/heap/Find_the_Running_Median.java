import java.io.*;
import java.util.PriorityQueue;

public class Find_the_Running_Median {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    class FindMean{
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;
        FindMean(){
            left = new PriorityQueue<>((a,b)->b-a);
            right = new PriorityQueue<>();
        }
        double add(int value){
            if(left.isEmpty()) left.add(value);
            else{
                if(left.size() > right.size()){
                    int a = left.peek();
                    if(a>value){
                        right.add(left.poll());
                        left.add(value);
                    }else{
                        right.add(value);
                    }
                }else if(right.size() > left.size()){
                    int a = right.peek();
                    if(value > a){
                        left.add(right.poll());
                        right.add(value);
                    }else{
                        left.add(value);
                    }
                }else{
                    int a = left.peek();
                    if(value > a) right.add(value);
                    else left.add(value);
                }
            }
            

            

            if(left.size() > right.size()){
                return (double) left.peek();
            }else if(right.size() > left.size()){
                return (double) right.peek();
            }else{
                return ((double) left.peek() + (double) right.peek()) / 2d;
            }
            

        }
    }

    void run() throws IOException {
        int n = i();
        FindMean fm = new FindMean();
        for(int i = 0;i<n;i++){
            writer.println(fm.add(i()));
        }
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        Find_the_Running_Median obj = new Find_the_Running_Median();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public Find_the_Running_Median(){
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


