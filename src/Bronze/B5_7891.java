package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B5_7891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int TC = Integer.parseInt(br.readLine());
        for (int i = 0; i < TC; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            bw.write(String.valueOf(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()))+"\n");
        }
        bw.flush();
    }
}
