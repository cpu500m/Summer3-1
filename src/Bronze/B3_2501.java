package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_2501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int order = Integer.parseInt(st.nextToken());
        int cur = 0;
        for(int i = 1; i <= N; i++){
            if( N % i == 0){
                cur++;
                if(order == cur){
                    bw.write(String.valueOf(i));
                    break;
                }
            }
        }
        if(cur < order)
            bw.write("0");
        bw.flush();
    }
}
