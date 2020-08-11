import java.io.*;

class POPGATES {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    void run() throws IOException {
        int t = getInt();
        while(t-->0){
            int[] c = ints();
            String[] d = bf.readLine().split(" ");
            int flip = 0;
            for(int i = d.length-1,j=0;j<c[1];i--,j++){
                if(flip == 0 && d[i].equals("H")) flip ^=1;
                if(flip == 1 && d[i].equals("T")) flip ^=1;
            }
            int cc = 0;
            for(int i = 0,h=d.length - c[1];i<h;i++){
                if(flip == 1 && (d[i].equals("T"))) cc++;
                if(flip == 0 && (d[i].equals("H"))) cc++;
            }
            sb.append(cc).append("\n");

        }
        writer.println(sb.toString().trim());
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        POPGATES obj = new POPGATES();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public POPGATES(){
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


