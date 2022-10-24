package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B1_2163 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = Integer.parseInt(st.nextToken())*Integer.parseInt(st.nextToken())-1;
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
