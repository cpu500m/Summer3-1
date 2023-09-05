package Bronze;

import java.io.*;

public class B2_29614 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        double score = 0;
        int[] ref_arr = {4, 3, 2, 1, -1, -1};
        int subject_cnt = 0;
        double cur_score = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if('A' <= c && c <= 'F') {
                if (cur_score != 0) {
                    if(cur_score != -1)
                        score = (score+cur_score);
                    subject_cnt++;
                }
                cur_score = ref_arr[c - 'A'];
            }
            else{
                cur_score += 0.5;
                score = (score+cur_score);
                cur_score = 0;
                subject_cnt++;
            }
        }
        if(cur_score !=0) {
            if(cur_score != -1)
                score += cur_score;
            subject_cnt++;
        }
        bw.write(String.format("%.5f",score/subject_cnt));
        bw.flush();
    }
}
