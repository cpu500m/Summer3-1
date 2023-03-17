package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_11944 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        int M = Integer.parseInt(st.nextToken());
        int len = N.length();

        int cur = 0;
        for(int i = 0 ; i < Integer.parseInt(N) ; i++){
            cur += len;
            sb.append(N);
            if(cur  >= M) break;
        }

        if(len*Integer.parseInt(N) > M){
            bw.write(sb.substring(0,M));
        }
        else bw.write(sb.toString());
        bw.flush();
    }
}
