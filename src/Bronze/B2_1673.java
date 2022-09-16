package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_1673 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String input;
        StringTokenizer st;
        int n ,k ;
        int coupons , chickens, stamps;
        while((input = br.readLine()) != null){
            st = new StringTokenizer(input);
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            chickens = n;
            stamps = n;
            coupons = (stamps/k);
            stamps %=k;

            while(coupons > 0){
                chickens+=coupons;
                stamps+=coupons;
                coupons = stamps/k;
                stamps %= k;
            }
            sb.append(chickens+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
