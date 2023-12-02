package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_2511 {

    public static final int SIZE = 10;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[SIZE];
        int[] b = new int[SIZE];

        int[] score = new int[2];
        int last = -1;
        for (int i = 0; i < SIZE; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < SIZE; i++) {
            b[i] = Integer.parseInt(st.nextToken());
            if (a[i] > b[i]) {
                last = i;
                score[0] += 3;
            } else if (a[i] < b[i]) {
                last = i;
                score[1] += 3;
            } else {
                score[0] += 1;
                score[1] += 1;

            }
        }
        bw.write(score[0] + " " + score[1] + "\n");
        if (score[0] > score[1]) bw.write("A");
        else if (score[0] < score[1]) bw.write("B");
        else {
            if (last == -1) bw.write("D");
            else {
                if (a[last] > b[last]) bw.write("A");
                else bw.write("B");
            }
        }
        bw.flush();
    }
}
