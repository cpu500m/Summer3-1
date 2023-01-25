package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_10093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        if(A >B){
            long temp = B;
            B = A;
            A = temp;
        }
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(long i = A+1 ; i < B; i++) {
            cnt ++;
            sb.append(i + " ");
        }
        bw.write(cnt+"\n"+sb.toString());
        bw.flush();
    }
}
