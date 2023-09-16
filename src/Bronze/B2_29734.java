package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_29734 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        long zip = cal1(n, s);

        long dok = cal2(m, t, s);

        bw.write(zip > dok ? "Dok\n" + dok : "Zip\n" + zip);
        bw.flush();
    }

    private static long cal2(long m, int t, int s) {
        long dok = (m /8)*(8 + 2* t + s);
        if (m % 8 != 0) {
            dok += (t + m % 8);
        }
        else dok -= (t +s);
        return dok;
    }

    private static long cal1(long n, int s) {
        long zip = (n / 8) * (8 + s);
        if (n % 8 != 0) {
            zip += (n % 8);
        } else zip -= s;
        return zip;
    }
}
