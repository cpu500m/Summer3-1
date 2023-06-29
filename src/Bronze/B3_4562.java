package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_4562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st ;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) >= Integer.parseInt(st.nextToken()))
                bw.write("MMM BRAINS\n");
            else bw.write("NO BRAINS\n");
        }
        bw.flush();
    }
}
