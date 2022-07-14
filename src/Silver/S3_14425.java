package Silver;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class S3_14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;
        HashMap<String,Integer> arr = new HashMap<>();
        for(int i = 0 ; i <N ; i++)
             arr.put(br.readLine(),i);
        for(int i = 0 ; i<M ; i++){
            if(arr.get(br.readLine()) != null)
                count++;
        }
        bw.write(String.valueOf(count));
        bw.flush();
    }
}
