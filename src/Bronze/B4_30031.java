package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B4_30031 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] money = {1000, 5000, 10000, 50000};

        StringTokenizer st;
        int result = 0;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            result += money[(Integer.parseInt(st.nextToken())-136)/6];
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
