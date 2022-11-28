package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_2460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int cur = 0;
        int max = 0;
        for(int i = 0 ;i < 10 ; i++){
            st = new StringTokenizer(br.readLine());
            cur -= Integer.parseInt(st.nextToken());
            cur += Integer.parseInt(st.nextToken());
            if( cur > max)
                max = cur;
        }
        bw.write(String.valueOf(max));
        bw.flush();
    }
}
