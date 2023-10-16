package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_2909 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder("1");
        int cnt = Integer.parseInt(st.nextToken());

        for (int i = 0; i < cnt; i++) {
            sb.append("0");
        }
        int p = Integer.parseInt(sb.toString());
        int result = (c / p) * p;
        c -= result;
        if(p/2 <= c && c != 0) c = p;
        else c = 0;

        bw.write(String.valueOf(result + c));
        bw.flush();
    }
}
