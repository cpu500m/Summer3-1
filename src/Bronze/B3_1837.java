package Bronze;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class B3_1837 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger p = new BigInteger(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[] check = new boolean[k + 1];

        use_eratosthenes_sieve(check);

        int res = logic(p, k, check);
        if (res == -1) bw.write("GOOD");
        else bw.write("BAD " + String.valueOf(res));
        bw.flush();
    }

    /**
     *
     * return value == -1 -> GOOD
     * else -> BAD + val
     */
    private static int logic(BigInteger p, int k, boolean[] check) {
        int val = -1;
        for (int i = 2; i < k; i++) {
            if(check[i]) continue;
            // 나눠 떨어지는 곱이라면
            if (judge(p, i)) {
                val = i;
                break;
            }
        }
        return val;
    }

    private static boolean judge(BigInteger p, int i) {
        return p.remainder(new BigInteger(String.valueOf(i))).toString().equals("0");
    }

    /**
     * 걍 초기화 귀찮으니깐
     * true : 소수가 아니다 / false : 소수이다
     */
    private static void use_eratosthenes_sieve(boolean[] arr) {
        arr[0] = true;
        arr[1] = true;
        for (int i = 2; i < arr.length; i++) {
            if(arr[i]) continue;
            for (int j = 2 * i; j < arr.length; j += i) {
                arr[j] = true;
            }
        }
    }
}
