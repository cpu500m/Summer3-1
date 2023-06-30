package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B4_3046 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        double s = Double.parseDouble(st.nextToken());
        bw.write((String.valueOf((int)(s*2 - r1))));
        bw.flush();

    }
}
