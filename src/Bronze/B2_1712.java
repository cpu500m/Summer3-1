package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_1712 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long fix = Long.parseLong(st.nextToken());
        long variable = Long.parseLong(st.nextToken());
        long  price = Long.parseLong(st.nextToken());
        long count;
        if( variable >= price) {
            bw.write("-1");
            bw.flush();
            return ;
        }
        count = (fix/(price-variable))+1;
        bw.write(String.valueOf(count));
        bw.flush();
    }
}
