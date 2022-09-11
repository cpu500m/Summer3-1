package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_1547 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int M = Integer.parseInt(br.readLine());
        int cur = 1;
        int a, b;
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if( a == cur)
                cur = b;
            else if(b == cur)
                cur = a;
        }
        bw.write(String.valueOf(cur));
        bw.flush();
    }
}
