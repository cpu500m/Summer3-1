package Silver;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class S3_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Map<String,Integer> clothes;
        int loop_count = Integer.parseInt(br.readLine());
        int clothes_count;
        int result;
        String kind;
        for(int i = 0 ; i < loop_count ; i++){
            clothes_count = Integer.parseInt(br.readLine());
            clothes = new HashMap<>();
            result = 1;
            for(int j = 0 ; j < clothes_count ; j++){
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                kind = st.nextToken();
                if(clothes.containsKey(kind)){
                    clothes.put(kind, clothes.get(kind)+1);
                }
                else
                    clothes.put(kind,1);
            }
            for (String str : clothes.keySet()){
                result*=(clothes.get(str)+1);
            }
            sb.append(result-1+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
