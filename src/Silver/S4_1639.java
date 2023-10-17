package Silver;

import java.io.*;

public class S4_1639 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();

        int result =0 ;
        int len = str.length();
        // 외부 루프 ( 브루트포스로)
        for (int i = 0; i < len; i++) {
            // 내부 루프
            int leftSum = 0;
            int rightSum = 0;
            for (int j = 0; j < len; j++) {
                if((i-j-1) < 0 || (i+j) >= len) break;
                leftSum += str.charAt(i-j-1)-'0';
                rightSum += str.charAt(i+j)-'0';
                if(leftSum == rightSum) {
                    if(result < 2*(j+1))
                         result = 2 * (j+1);
                }
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
