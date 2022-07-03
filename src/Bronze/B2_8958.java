package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int loop_count = Integer.parseInt(br.readLine());
        int continuous_o;
        int sum=0;
        StringTokenizer st;
        String cur_quest;
        for(int i = 0 ; i< loop_count ; i++){
            sum = 0;
            continuous_o= 0;
            st = new StringTokenizer(br.readLine());
            cur_quest = st.nextToken();
            for(int j = 0 ; j < cur_quest.length(); j++) {
                if (cur_quest.charAt(j) == 'O') {
                    continuous_o++;
                    sum+=continuous_o;
                } else {
                    continuous_o = 0;
                }
            }
            bw.write(String.valueOf(sum)+"\n");
        }
        bw.flush();
    }
}
