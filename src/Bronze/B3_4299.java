package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_4299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = Integer.parseInt(st.nextToken());
        int diff = Integer.parseInt(st.nextToken());
        int win_score=0;
        if( (sum+diff) %2 != 0 || sum < diff){
            bw.write("-1");
            bw.flush();
            return ;
        }
        else
           win_score = (sum+diff)/2;
        bw.write(String.valueOf(win_score)+" "+String.valueOf(sum-win_score));
        bw.flush();
    }
}
