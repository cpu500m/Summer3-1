package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_23971 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r_cnt = (int)Math.ceil((double)h/(n+1)) , c_cnt = (int)Math.ceil((double)w/(m+1)) ;
        bw.write(String.valueOf(r_cnt*c_cnt));
        bw.flush();
    }
}
