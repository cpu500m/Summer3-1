package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_11134 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int day, a, b;
        for (int i = 0; i < n; i++) {
            day = 0;
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            day = a / b;
            a = a % b;
            if (a != 0)
                day++;
            sb.append(day + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
