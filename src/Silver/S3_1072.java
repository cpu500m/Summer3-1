package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S3_1072 {
    final static int MAX = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());

        long rate = (y*100)/x;
        if(rate >98) bw.write("-1");
        else{
            long res = binary_find(0, MAX, x, y, rate);
            bw.write(String.valueOf(res));
        }
        bw.flush();
    }
    private static long binary_find(int low , int high ,long x, long y, long rate) {
        while (low+1 < high) {
            int mid = low + (high - low) / 2;
            if ((y + mid) * 100 / (x + mid) > rate)
                high = mid;
            else low = mid;
        }
        return high;
    }
}
