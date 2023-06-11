package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B4_21591 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        w = (w- Integer.parseInt(st.nextToken()))/2;
        h = (h - Integer.parseInt(st.nextToken()))/2;
        if( w>= 1 && h >= 1)
            bw.write("1");
        else bw.write("0");
        bw.flush();
    }
}
