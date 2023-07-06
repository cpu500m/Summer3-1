package Bronze;

import java.io.*;

public class B3_10886 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[2];
        for (int i = 0; i < N; i++) {
            cnt[br.readLine().charAt(0) - '0']++;
        }
        bw.write("Junhee is " + (cnt[0] > cnt[1] ? "not cute!" : "cute!"));
        bw.flush();
    }
}
