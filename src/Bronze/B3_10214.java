package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_10214 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            int[] score = new int[2];
            for (int j = 0; j < 9; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                score[0] += Integer.parseInt(st.nextToken());
                score[1] += Integer.parseInt(st.nextToken());
            }
            if(score[0] > score[1]) bw.write("Yonsei\n");
            else if(score[0]< score[1]) bw.write("Korea\n");
            else bw.write("Draw\n");
        }
        bw.flush();
    }
}
