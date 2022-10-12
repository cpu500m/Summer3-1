package Bronze;

import java.io.*;

public class B3_2556 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++)
                arr[i][j] = '*';
        }
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++)
                bw.write(arr[i][j]);
            if (i != N)
                bw.write("\n");
        }
        bw.flush();
    }
}
