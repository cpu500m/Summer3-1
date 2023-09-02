package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B1_1268 {

    public static final int CLASS = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] info = new int[n][CLASS];
        
        processInput(br, n, info);

        boolean[][] check = new boolean[n][n];
        
        checkFriend(n, info, check);

        int answer = findNum(n, check);

        bw.write(String.valueOf(answer));
        bw.flush();
    }

    private static int findNum(int n, boolean[][] check) {
        int nax_cnt = 0;
        int max_idx = 0;
        for (int i = 0; i < n; i++) {
            int cur_cnt = 0;
            for (int j = 0; j < n; j++) {
                if(check[i][j])
                    cur_cnt++;
            }
            if(cur_cnt > nax_cnt){
                nax_cnt = cur_cnt;
                max_idx = i+1;
            }
        }
        return max_idx;
    }

    private static void checkFriend(int n, int[][] info, boolean[][] check) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < CLASS; k++) {
                    // 본인체크해도 뭐 전부 +1이니깐
                    if(info[i][k] == info[j][k]){
                        check[i][j] = true;
                        check[j][i] = true;
                        break;
                    }
                }
            }
        }
    }

    private static void processInput(BufferedReader br, int n, int[][] info) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < CLASS; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
