package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B5_2420 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long result = Math.abs(Long.parseLong(st.nextToken()) -Long.parseLong(st.nextToken()));
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
