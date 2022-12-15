package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_2711 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb;
        int idx;
        String str;
        for(int i = 0 ; i< n ; i++){
            st = new StringTokenizer(br.readLine());
            idx = Integer.parseInt(st.nextToken());
            sb = new StringBuilder();
            sb.append(st.nextToken());
            sb.delete(idx-1,idx);
            bw.write(sb.toString()+"\n");
        }
        bw.flush();
    }
}
