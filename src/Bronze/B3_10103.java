package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_10103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int a = 100, b = 100;
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());
            if(s1 > s2)
                b -= s1;
            else if(s1 < s2) a -= s2;
        }
        bw.write(String.valueOf(a) + "\n");
        bw.write(String.valueOf(b));
        bw.flush();
    }
}
