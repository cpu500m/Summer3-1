package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S3_1051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] arr = new char[n][m];

        // 걍 머 N^3 떄려도 넉넉하니깐 구현하자
        /* 입력  */
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int max = 1;
        for (int i = 0; i < n; i++) {
            if((n-(i+1)) < max) break;
            for (int j = 0; j < m; j++) {
                if((m-(j+1)) < max) break;

                // 맨 끝부터해서 같은지 다른지 비교해봐야할듯
                for (int k = m-1; k > j; k--) {
                    // 세로로 충분한 길이가 있는지 검사
                    if( i+ (k - j) > n-1) continue;
                    if(max > k-j+1) break;

                    if(arr[i][j] == arr[i][k] && arr[i][j] == arr[i+(k-j)][j] && arr[i][j] == arr[i+(k-j)][k]){
                        max = k - j + 1;
                        break;
                    }
                }

            }
        }
        bw.write(String.valueOf(max*max));
        bw.flush();
    }
}
