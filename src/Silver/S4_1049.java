package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S4_1049 {
    private static final int MAX =1001;
    private static final int SET_COUNT = 6;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int set_min_price = MAX;
        int single_min_price = MAX;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int set_price = Integer.parseInt(st.nextToken());
            int single_price = Integer.parseInt(st.nextToken());
            set_min_price = set_min_price > set_price ? set_price : set_min_price;
            single_min_price = single_min_price > single_price ? single_price : single_min_price;
        }
        if(single_min_price * 6 < set_min_price)
            bw.write(String.valueOf(single_min_price*n));
        else{
            int div = n / SET_COUNT;
            int rm = n % SET_COUNT;
            int sum = div * set_min_price;
            if(single_min_price*rm > set_min_price)
                sum += set_min_price;
            else sum += single_min_price * rm;
            bw.write(String.valueOf(sum));
        }
        bw.flush();
    }
}
