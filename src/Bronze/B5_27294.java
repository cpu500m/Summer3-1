package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B5_27294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        if( s == 1 || (t < 12 || t > 16))
            bw.write("280");
        else bw.write("320");
        bw.flush();
    }
}
