// 그냥 처음 푼거는
// 단순하게 dp이용 가장긴 오름차순 && dp 이용 가장 긴 내림차순 합쳐서 풀어서 맞췄는데
// 더 좋은 알고리즘이 있을 것 같아서 찾아 봄.
// 일단 왼쪽부터 오른쪽으로가며 오름차순으로 정렬 + 오른쪽에서 왼쪽으로 오름차순 정렬
// 하고 더하면 중복되는 값이 하나 발생하므로 -1 해줘서 가장 긴 바이토닉 수열을 구하는 방법을 찾았음.
// 근데 찾아보니 좀더 개선된 알고리즘이 있어서 그 방식을 12015 번에 적용.
package Gold;

import java.io.*;
import java.util.StringTokenizer;

public class G3_11054 {
    private static int[] arr;
    private static int[] dp1;
    private static int[] dp2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dp1 = new int[N + 1];
        dp2 = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        bw.write(String.valueOf(getMinLength(N)));

        bw.flush();
    }
    private static int getMinLength(int N) {
        dp1[1] = 1;
        dp2[N] = 1;
        int max_len = -1;
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[i] && max_len < dp1[j]) {
                    max_len = dp1[j];
                }
            }
            if (max_len == -1)
                dp1[i] = 1;
            else
                dp1[i] = max_len + 1;
            max_len = -1;
        }
        for (int i = N-1; i >= 1; i--) {
            for (int j = N; j > i; j--) {
                if (arr[j] < arr[i] && max_len < dp2[j]) {
                    max_len = dp2[j];
                }
            }
            if (max_len == -1)
                dp2[i] = 1;
            else
                dp2[i] = max_len + 1;
            max_len = -1;
        }

        for (int i = 1; i <= N; i++) {
            dp1[i] = dp1[i]+dp2[i]-1;
            if(max_len < dp1[i])
                max_len = dp1[i];
        }
        return max_len;
    }
}
    // 아래는 두번째로 개선한 방식
//    private static int getMinLength(int N) {
//        dp1[1] = 1;
//        dp2[N] = 1;
//        int max_len = -1;
//        for (int i = 2; i <= N; i++) {
//            for (int j = 1; j < i; j++) {
//                if (arr[j] < arr[i] && max_len < dp1[j]) {
//                    max_len = dp1[j];
//                }
//            }
//            if (max_len == -1)
//                dp1[i] = 1;
//            else
//                dp1[i] = max_len + 1;
//            max_len = -1;
//        }
//        for (int i = N-1; i >= 1; i--) {
//            for (int j = N; j > i; j--) {
//                if (arr[j] < arr[i] && max_len < dp2[j]) {
//                    max_len = dp2[j];
//                }
//            }
//            if (max_len == -1)
//                dp2[i] = 1;
//            else
//                dp2[i] = max_len + 1;
//            max_len = -1;
//        }
//
//        for (int i = 1; i <= N; i++) {
//            dp1[i] = dp1[i]+dp2[i]-1;
//            if(max_len < dp1[i])
//                max_len = dp1[i];
//        }
//        return max_len;
//    }
//}
    // 처음에 푼 방식
//    private static int getMinLength(int N) {
//        dp[1] = 1;
//        int max_len = -1;
//        int max1=-1 , max2=-1;
//        for (int i = 2; i <= N; i++) {
//            for (int j = 1; j < i; j++) {
//                if (arr[j] < arr[i] && max_len < dp[j]) {
//                    max_len = dp[j];
//                }
//            }
//            if(max_len == -1)
//                dp[i] = 1;
//            else
//                dp[i] = max_len+1;
//            max_len = -1;
//        }
//        for (int i = 2; i <= N; i++) {
//            for (int j = 1; j < i; j++) {
//                if (arr[j] > arr[i] && dp[j] >= dp[i] &&max_len < dp[j]) {
//                    max_len = dp[j];
//                }
//            }
//            if(max_len == -1)
//                continue;
//            else
//                dp[i] = max_len+1;
//            max_len = -1;
//        }
//        for(int i =  1; i <= N ;i++){
//            if(max1< dp[i])
//                max1 = dp[i];
//        }
//        for (int i = 2; i <= N; i++) {
//            for (int j = 1; j < i; j++) {
//                if (arr[j] > arr[i] &&max_len < dp[j]) {
//                    max_len = dp[j];
//                }
//            }
//            if(max_len == -1)
//                continue;
//            else
//                dp[i] = max_len+1;
//            max_len = -1;
//        }
//        for(int i =  1; i <= N ;i++){
//            if(max2< dp[i])
//                max2 = dp[i];
//        }
//        return Math.max(max1,max2);
//    }
