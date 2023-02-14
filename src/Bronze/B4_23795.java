package Bronze;

import java.io.*;

public class B4_23795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int res = 0;
        int cur;
        while ((cur = Integer.parseInt(br.readLine())) != -1){
            res+= cur;
        }
        bw.write(String.valueOf(res));
        bw.flush();
    }
}
