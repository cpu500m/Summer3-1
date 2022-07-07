package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S5_2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int move = Integer.parseInt(st.nextToken());
        int slip = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int day = 1;
        int real_mv = move - slip;
        day += (height-move)/ real_mv;
        if(((height-move) % real_mv) != 0)
            day+=1;
        bw.write(String.valueOf(day));
        bw.flush();
    }
}
