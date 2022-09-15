package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_1233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int max_value = 0;
        int idx = 0;
        int[] check = new int[81];
        for (int i = 1; i <= a; i++){
            for (int j = 1; j <= b; j++)
                for (int k = 1; k <= c; k++)
                    check[i + j + k]++;
        }
        for(int i = 3; i < 81; i++){
            if(check[i] > max_value) {
                max_value = check[i];
                idx = i;
            }
        }
        bw.write(String.valueOf(idx));
        bw.flush();
    }
}
