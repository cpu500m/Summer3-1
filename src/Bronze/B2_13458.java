package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st2.nextToken()) , c = Integer.parseInt(st2.nextToken());
        long i , cnt = 0 , cur;
        for(i = 0 ; i < n ; i++){
            cur = Integer.parseInt(st.nextToken());
            cur -= b;
            cnt++;
            if(cur < 1)
                continue;
            cnt += cur/c;
            if(cur % c != 0)
                cnt++;
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}
