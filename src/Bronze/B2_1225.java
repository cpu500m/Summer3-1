package Bronze;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class B2_1225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        // 그냥 하면 O(N^2)  N <= 10000
        // 이니깐 O(N) 으로 해야 됨
        BigInteger res = new BigInteger("0");
        int[] cnt = new int[10];

        // 자릿수를 센다
        countDigit(a, cnt);

        // 곱셈 수행
        res = logic(b, res, cnt);

        bw.write(String.valueOf(res));
        bw.flush();
    }

    private static BigInteger logic(String b, BigInteger res, int[] cnt) {
        for (int i = 0; i < b.length(); i++) {
            for (int j = 0; j < cnt.length; j++) {
                BigInteger multiplyValue = new BigInteger(String.valueOf(cnt[j]*j));
                res = res.add(new BigInteger(String.valueOf(b.charAt(i))).multiply(multiplyValue));
            }
        }
        return res;
    }

    private static void countDigit(String a, int[] cnt) {
        for (int i = 0; i < a.length(); i++) {
            cnt[a.charAt(i)-'0']++;
        }
    }
}
