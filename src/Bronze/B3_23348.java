package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_23348 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] score = new int[3];
        for (int i = 0; i < score.length; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int cur = 0;
            for (int j = 0; j < 3; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < score.length; k++) {
                    cur += Integer.parseInt(st.nextToken()) * score[k];
                }
            }
            if(cur > max)
                max = cur;
        }
        bw.write(String.valueOf(max));
        bw.flush();
    }
}
