package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_5176 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int P, M , count;
        boolean[] check;
        int loop_count = Integer.parseInt(br.readLine()), seat;
        for (int i = 0; i < loop_count; i++) {
            st = new StringTokenizer(br.readLine());
            P =Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            count = 0;
            check = new boolean[M+1];
            for(int j = 0; j <P ; j++){
                seat = Integer.parseInt(br.readLine());
                if(check[seat])
                    count++;
                else
                    check[seat] = true;
            }
            sb.append(String.valueOf(count)+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
