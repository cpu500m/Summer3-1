package Silver;

import java.io.*;
import java.util.*;

public class S4_1764 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count=0;
        Map<String,Integer> arr = new HashMap<>();
        Map<String,Integer> sorted = new HashMap<>();
        String str;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i <N; i++)
            arr.put(br.readLine(), i);
        for(int j = 0 ; j < M; j++) {
            str = br.readLine();
            if (arr.containsKey(str)) {
                sorted.put(str,j);
                count++;
            }
        }
        List<Map.Entry<String,Integer>> entryList = new LinkedList<>(sorted.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        for(Map.Entry<String,Integer> entry : entryList)
            sb.append(entry.getKey()+"\n");
        bw.write(String.valueOf(count)+"\n"+sb.toString());
        bw.flush();
    }
}
