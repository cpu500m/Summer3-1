package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_1357 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String X = st.nextToken();
        String Y = st.nextToken();
        int rev_x = reverse(X);
        int rev_y = reverse(Y);
        bw.write(String.valueOf(reverse(String.valueOf(rev_x+rev_y))));
        bw.flush();
    }
    private static int reverse(String n){
        int up = 1;
        int result = 0;
        for(int i = 0 ; i < n.length(); i++){
            result +=Character.getNumericValue(n.charAt(i))*up;
            up*=10;
        }
        return result;
    }
}
