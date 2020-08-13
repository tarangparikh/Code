public class Stack{
    int[] d;
    int t;
    Stack(){
        d = new int[1<<10];
        t = -1;
    }
    boolean isEmpty(){
        return t==-1;
    }
    int peek(){
        return d[t];
    }
    int pop(){
        return d[t--];
    }
    void push(int v){
        if(t==d.length-1) resize();
        d[++t] = v;
    }
    void resize(){
        int[] s = new int[d.length<<1];
        System.arraycopy(d,0,s,0,d.length);
        d = s;
    }
}