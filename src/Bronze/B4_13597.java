package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B4_13597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        bw.write(a > b ? String.valueOf(a) : String.valueOf(b));
        bw.flush();
    }
}
