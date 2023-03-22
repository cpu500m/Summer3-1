package Bronze;

import java.io.*;
import java.util.Arrays;

public class B2_5576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int[] score = new int[10];
        for(int i = 0 ; i < 2 ; i++){
            for(int j = 0 ; j < 10; j++)
                score[j] = Integer.parseInt(br.readLine());
            Arrays.sort(score);
            int sum = 0;
            for(int j = 7; j < 10 ; j++)
                sum += score[j];
            sb.append(sum+" ");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
