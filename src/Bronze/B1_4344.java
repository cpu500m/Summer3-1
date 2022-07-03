/* 2022-07-02 */
package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B1_4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int loop_count = Integer.parseInt(br.readLine());
        int student_count;
        int mean_count=0;
        int[] score;
        float percent = 0;
        float mean=0;
        StringTokenizer st;
        for(int i= 0 ; i < loop_count ; i++){
            st = new StringTokenizer(br.readLine());
            student_count = Integer.parseInt(st.nextToken());
            score = new int[student_count];
            for(int j = 0; j < student_count ; j++){
                score[j] = Integer.parseInt(st.nextToken());
                mean+=score[j];
            }
            mean = mean / student_count;
            for(int j = 0; j < student_count ; j++){
                if(score[j] > mean)
                    mean_count++;
            }
            percent = ((float)mean_count/student_count)*100;
            bw.write(String.format("%.3f%%\n",percent));
            mean =0;
            mean_count=0;
        }
        bw.flush();
    }
}
