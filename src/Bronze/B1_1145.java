package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B1_1145 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 브루트포스로 그냥 돌리면 흠
        // 어차피 근데 100이하라 낭낭하다
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int cur = 3;
        int cnt = 0;
        while (cnt < 3) {
            cnt = 0;
            cur++;
            for (int i = 0; i < 5; i++) {
                if(cur % arr[i] == 0)
                    cnt++;
            }
        }
        bw.write(String.valueOf(cur));
        bw.flush();
    }
}
