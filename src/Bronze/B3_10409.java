package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_10409 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int cnt = 0;
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if( sum + cur <= t){
                cnt++;
                sum += cur;
            }
            else break;
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}
