package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_1173 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());


        int time = 0;
        int cur = 0;
        int curM = m;
        while (cur != N) {
            if(curM + T <= M){
                curM += T;
                cur++;
            }
            else{
                if(curM == m){
                    time = -1;
                    break;
                }
                curM = (curM - R >= m ? curM - R : m);
            }
            time++;
        }
        bw.write(String.valueOf(time));
        bw.flush();
    }
}
