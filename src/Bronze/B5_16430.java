package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B5_16430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
        int numerator = b - a;
        bw.write(numerator + " " + b);
        bw.flush();
    }
}
