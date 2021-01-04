import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;
import java.util.StringTokenizer;

public class App {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    class Heap{
        int[] h;
        int n;
        Heap(){
            this.h = new int[1<<10];
            this.n = 0;
        }
        void up(int i){
            while(i > 0){
                int p = (i - 1) >> 1;
                if(h[p] >= h[i]) break;
                swap(p,i);
                i = p;
            }
        }
        void down(int i){
            while(true){
                int c = (i<<1) + 1;
                if(c >= n) break;
                if(h[i] > h[c]) c = i;
                if(c+1 < n && h[c + 1] > h[c]) c = c + 1;
                if(c == i) break;
                swap(c,i);
                i = c;
            }
        }

        void swap(int i,int j){
            int t = h[i];
            h[i] = h[j];
            h[j] = t;
        }
    }
    
    void merge(int[] data,int a,int b,int c){
        int[] temp = new int[c - a + 1];
        int i = a;
        int j = b;
        int k = 0;
        while(i < b && j <= c)  temp[k++] = data[i] < data[j] ? data[i++] : data[j++];
        while(i < b) temp[k++] = data[i++];
        while(j <= c) temp[k++] = data[j++];
        while(k-->0) data[a + k] = temp[k];
    }
    void sort(int[] data,int i,int j){
        if(j - i + 1 <= 1) return;
        int mid = (i + j) >> 1;
        //System.out.println(i+" "+j);
        sort(data,i,mid);
        sort(data,mid+1,j);
        merge(data, i, mid + 1, j);

    }
    void sort(int[] d){
        int n = d.length;
        int[] buffer = new int[n];
        int limit = Integer.highestOneBit(n) << 1;
        for(int i = 2;i<=limit;i<<=1){
            //System.out.println("i : "+i);
            for(int j = 0;j<n;j+=i){
                int k = 0;
                int a = j;
                int b = j + (i >> 1);
                if(b >= n) continue;
                int alen = b;
                int blen = Math.min(a + i, n);
                //System.out.println(a+" "+b);
                while(a < alen && b < blen) buffer[k++] = d[a] <= d[b] ? d[a++] : d[b++];
                while(a < alen) buffer[k++] = d[a++];
                while(b < blen) buffer[k++] = d[b++];
                while(k-->0) d[j+k] = buffer[k];
            }
        }
    }

    boolean isSame(int[] a,int[] b){
        if(a.length != b.length) return false;
        for(int i = 0;i<a.length;i++)
            if(a[i] != b[i]) return false;
        return true;
    }
    

    boolean isNumber(char a){
        return a>='0' && a<='9';
    }

    int getPrecedence(char a){
        return a == '*' || a == '/' ? a == '+' || a == '-' ? 2 : 1 : 0;
    }

    char[] postfixExpression(char[] expression){
        int length = expression.length;
        char[] holder = new char[length];
        char[] stack = new char[length];
        int toph = 0;
        int tops = -1;

        for(int i = 0 ; i < length ; i++){
            if(isNumber(expression[i])) holder[toph++] = expression[i];
            else{
                while(tops!=-1 && getPrecedence(stack[tops]) > getPrecedence(expression[i])) holder[toph++] = stack[tops--];
                stack[++tops] = expression[i];
            }
        }

        while(tops!=-1) holder[toph++] = stack[tops--];

        return holder;
    }

    int evaluate(char[] postfix){
        int length = postfix.length;
        int[] stack = new int[length];
        int tops = -1;
        for(int i = 0 ; i < length ; i++ ){
            if(isNumber(postfix[i])) stack[++tops] = Integer.parseInt(Character.toString(postfix[i]));
            else{
                int a = stack[tops--];
                int b = stack[tops--];
                int result = evaluate(b, a, postfix[i]);
                stack[++tops] = result;
            }
        }
        return stack[tops--];
    }

    Integer evaluate(int a,int b,char operator){
        switch(operator){
            case '+' : return a+b;
            case '-' : return a-b;
            case '/' : return a/b;
            case '*' : return a*b;
            default : return null;
        }
    }

    void run() throws IOException {
        char[] d = "5+4/2".toCharArray();
        System.out.println(evaluate(postfixExpression(d)));
    }

    String upperTriangle(int size,char character){
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<size;i++){
            for(int j = 0,h=size - i - 1;j<h;j++) sb.append(' ');
            for(int j = 0,h=(2*i + 1);j<h;j++) sb.append(character); 
            sb.append('\n');
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        App obj = new App();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public App(){
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


