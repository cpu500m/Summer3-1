package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_30019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] room = new int[n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int s =Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if(room[num-1] <= s){
                sb.append("YES\n");
                room[num-1] = e;
            } else sb.append("NO\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
