import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class _49 {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = false;

    List<List<String>> solve(String[] strs){
        TreeMap<int[],List<String>> map = new TreeMap<>((a,b) -> {
            for(int i = 0,l=Math.min(a.length,b.length);i<l;i++)
                if(a[i]!=b[i]) return a[i] - b[i];
            return 0;
        });
       
        for(String str : strs){
            char[] d = str.toCharArray();
            int[] key = new int[26];
            for(char e : d) key[e - 'a']++;
            if(!map.containsKey(key)) map.put(key,new ArrayList<>());
            List<String> list = map.get(key);
            list.add(str);
        }
        List<List<String>> list = new ArrayList<>();
        for(Map.Entry<int[],List<String>> entry : map.entrySet())
            list.add(entry.getValue());
        return list;
    }

    long mod = (1l<<53) - 1;
    
    long hash(int[] d){
        long v = 0;
        for(int e : d){
            v = v * 31 % mod;
            v = (v + e) % mod;
        }
        return v;
    }

    List<List<String>> solve1(String[] strs){
        HashMap<Long,List<String>> map = new HashMap<>();
        int[] f = new int[26];

        for(String str : strs){
            for(int i = 0,h=f.length;i<h;i++) f[i] = 0;
            for(char e : str.toCharArray())
                f[e - 'a']++;
            long key = hash(f);
            if(!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }

        List<List<String>> list = new ArrayList<>();
        for(Map.Entry<Long,List<String>> entry : map.entrySet())
            list.add(entry.getValue());

        return list;
    }

    List<List<String>> solve2(String[] strs){
        HashMap<Long,Integer> map = new HashMap<>();
        int size = 0;
        List<List<String>> list = new ArrayList<>();
        int[] f = new int[26];

        for(String str : strs){
            for(int i = 0,h=f.length;i<h;i++) f[i] = 0;
            for(char e : str.toCharArray())
                f[e - 'a']++;
            long key = hash(f);
            if(!map.containsKey(key)){
                list.add(new ArrayList<>());
                map.put(key,size++);
            }
            int index = map.get(key);
            list.get(index).add(str);
        }

        return list;
    }

    List<List<String>> solve3(String[] strs){
        

        return null;
    }


    void run() throws IOException {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(solve2(strs));
        
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        _49 obj = new _49();
        obj.run();
        long end_time = System.currentTimeMillis();
        if (local_system) obj.writer.println("Time : " + (end_time - start_time));
        obj.close();
    }

    public _49(){
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


