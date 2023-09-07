package Bronze;

import java.io.*;

public class B2_11104 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(Integer.valueOf(br.readLine(), 2) + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
