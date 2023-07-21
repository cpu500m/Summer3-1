package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S2_1182 {

    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        int ans = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 솔직히 걍 세그먼트 트리 쓰면 최적화같은데
        // N작으니까 걍 뭘 해도 널널하겠다
        // 가 아니고 다시 읽어보니 백트래킹이네
        for (int i = 0; i < n; i++) {
            ans += back_tracking(i+1, arr[i] , s);
        }
        bw.write(String.valueOf(ans));
        bw.flush();

    }
    private static int back_tracking(int cur, int sum , int valid) {

        // 종료
        if(cur == arr.length) {
            if(sum == valid)
                return 1;
            else return 0;
        }
        else {
            // 리턴
            int inc_v = back_tracking(cur + 1, sum + arr[cur], valid);
            int not_inc_val = back_tracking(cur + 1, sum, valid);

            return inc_v + not_inc_val;
        }

    }


}
