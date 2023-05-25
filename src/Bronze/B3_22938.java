package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_22938 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken())/2;
        int m = Integer.parseInt(st.nextToken())/2;
        bw.write(n > m ? String.valueOf(m) : String.valueOf(n));
        bw.flush();
    }
}
