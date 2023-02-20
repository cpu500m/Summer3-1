package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_19532 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        int ans1 , ans2;
        for(int i = - 999; i <= 999 ; i++){
            for(int j = -999; j <= 999 ; j++) {
                ans1 = a * i + b*j;
                ans2 =d*i + e*j;
                if(ans1 == c && ans2 == f) {
                    bw.write(i+ " " + j);
                    bw.flush();
                    return;
                }
            }
        }

    }
}
