import java.util.Comparator;
public class Array{
    static int max(int...d){
        int max = d[0];
        for(int e : d) max = Math.max(e,max);
        return max;
    }
    static int min(int...d){
        int min = d[0];
        for(int e : d) min = Math.min(e,min);
        return min;
    }
    static int bs(int[] d,int i,int j,int v){
        int mid = (i + j) >> 1;
        while(i<=j){
            mid = (i+j) >> 1;
            if(d[mid] == v) return mid;
            if(d[mid] > v) j = mid - 1;
            else i = mid + 1;
        }
        return -mid-1;
    }
    static boolean bs1(int[] d,int i,int j,int v){
        while(i<=j){
            int mid = (i + j)>>1;
            if(d[mid] == v) return true;
            if(d[mid]>v) j = mid-1;
            else i = mid+1; 
        }
        return false;
    }
    static <T> int bs1(T[] d,int i,int j,T v,Comparator<T> c){
        return 0;
    }
}