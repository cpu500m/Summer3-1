package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_5032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int result = 0, valid = e+f;
        while(valid/c > 0){
            result += valid/c;
            valid = valid/c + valid%c;
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
