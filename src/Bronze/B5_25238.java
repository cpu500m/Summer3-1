package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B5_25238 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=  new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = 100 - Integer.parseInt(st.nextToken());
        float damage = a* ((float)b/100);
        if( damage >=   100)
            bw.write("0");
        else bw.write("1");
        bw.flush();
    }
}
