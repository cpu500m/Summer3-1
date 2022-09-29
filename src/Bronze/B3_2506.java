package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_2506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int score = 0;
        int cur_score = 1;
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++) {
            if(st.nextToken().equals("1"))
                score+=cur_score++;
            else
                cur_score = 1;
        }
        bw.write(String.valueOf(score));
        bw.flush();
    }
}
