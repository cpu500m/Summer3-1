package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B4_30794 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int lv = Integer.parseInt(st.nextToken());
        char c = st.nextToken().charAt(0);
        if(c == 'm') bw.write("0");
        else if(c == 'b') bw.write(String.valueOf(200 * lv));
        else if(c == 'c') bw.write(String.valueOf(400 * lv));
        else if(c == 'g') bw.write(String.valueOf(600 * lv));
        else bw.write(String.valueOf(1000 * lv));
        bw.flush();
    }
}
