package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_10539 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;

        for(int i = 1 ; i <= n ; i++){
            int cur = Integer.parseInt(st.nextToken());
            cur= cur*i - sum;
            sum +=cur;
            sb.append(cur+" ");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
