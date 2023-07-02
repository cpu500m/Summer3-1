package Bronze;

import java.io.*;

public class B3_10991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][2 * N - 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N-i-1; j++) {
                arr[i][j] = ' ';
            }

            int cnt = 0;
            for (int j = N-i-1; j < 2*N-1; j++) {
                if(cnt++ % 2 == 0)
                    arr[i][j] = '*';
                else arr[i][j] = ' ';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N + i; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();

    }
}
