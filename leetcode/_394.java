import java.io.*;

class InvalidFormatException extends RuntimeException {
    InvalidFormatException(String s) {
        super(s);
    }
}

public class _394 {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;

    String solve(char[] d, int a, int b) throws InvalidFormatException {
        int last_number = 0;
        boolean number_found = false;
        for(int i = a; i < b; i++) {
            int t = isNumber(d[i]);
            if(t >= 0){
                number_found = true;
                last_number*=10;
                last_number+=t;
            }else if(number_found && isChar(d[i])){
                throw new InvalidFormatException("Invalid Format");
            }else if(number_found && isOpen(d[i])){

            }
        }
        return "";
    }

    private boolean isOpen(char d){
        return d == '[';
    }

    private boolean isChar(char d){
        return d >= 'a' && d <= 'z' || d >= 'A' && d <= 'Z';
    }

    private int isNumber(char d){
        if(d >= '0' && d <= '9')
            return d - '0';
        return -1;
    }

    void run() throws IOException {
        String s = bf.readLine();
        char[] d = s.toCharArray();
        int[] dp = new int[s.length()];
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        _394 obj = new _394();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public _394(){
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


