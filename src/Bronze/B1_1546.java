package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B1_1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int max_value = 0;
        float sum = 0;
        int subject = Integer.parseInt(br.readLine());
        int[] score = new int[subject];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i <subject;i++) {
            score[i] = Integer.parseInt(st.nextToken());
            if(max_value < score[i])
                max_value=score[i];
        }
        for(int i = 0 ; i <subject;i++){
            sum+=((float)score[i]/max_value)*100;
        }
        sum= sum / subject;
        bw.write(String.valueOf(sum));
        bw.flush();
    }
}
