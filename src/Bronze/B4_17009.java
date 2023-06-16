package Bronze;

import java.io.*;

public class B4_17009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] score = new int[2];
        for (int i = 0; i < 2; i++) {
            for(int j = 3 ; j > 0 ; j--)
                score[i] += Integer.parseInt(br.readLine())*j;
        }
        bw.write(score[0] > score[1] ? "A" : ((score[0] == score[1]) ? "T" : "B"));
        bw.flush();
    }
}
