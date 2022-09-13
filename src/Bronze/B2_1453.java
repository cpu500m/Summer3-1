package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_1453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        boolean[] pc = new boolean[101];
        int cnt = 0;
        int want;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            want = Integer.parseInt(st.nextToken());
            if(!pc[want]){
                pc[want] = true;
            }
            else
                cnt++;
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}
