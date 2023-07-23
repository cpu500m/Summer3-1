package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S2_1024 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        /* 내생각  */
        // 먼저 n을 l로 나눠 봄. (받는 값은 실수로)
        // 나눠서 나온 값이 .5의 형태거나 .0 여야 된단말이지?

        // l이 짝수 일 때 .0의 형태가 나오면 X.
        // l이 홀수 일 때 .5의 형태가 나오면 X.

        // n/l 을 시작값으로 하고 안되면 1씩 증가시키는 식으로.
        // 올림(n/l) - (l/2) < 0 이면 -1출력.
        int mid = -1;
        int r = -1;
        while (Math.ceil(n/(float)l) - (l/2) >= 0){
            // .0이나 .5의 형태가 아니면 죄다 넘김
            if(n % l != 0 && !(l % 2 == 0 && n % l == (l/2)) ){
                l++;
                continue;
            }

            // l이 짝수면서 .0의 형태인 경우
            if(n % l == 0 && l % 2 ==0) {
                l++;
                continue;
            }
            // l이 홀수이며 .5의 형태인 경우
            else if(n % l != 0 && l % 2 != 0){
                l++;
                continue;
            }

            mid = n / l;
            r = n % l;
            break;
        }

        if(mid == -1 || l > 100)
            sb.append("-1");
        else{
            int iteration = l / 2;
            // l이 홀수인 경우
            if (r == 0) {
                for (int i = mid - iteration; i < mid; i++) {
                    sb.append(i + " ");
                }
                for (int i = mid; i <= mid+iteration; i++) {
                    sb.append(i + " ");
                }
            }
            // l이 짝수인 경우
            else{
                for (int i = mid - iteration+1; i < mid; i++) {
                    sb.append(i + " ");
                }
                for (int i = mid; i <= mid+iteration; i++) {
                    sb.append(i + " ");
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
