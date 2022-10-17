package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_3034 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int max = (int)Math.sqrt(W*W+H*H);
        int input;
        StringBuilder sb =new StringBuilder();
        for(int i= 0; i < N ; i++){
            input = Integer.parseInt(br.readLine());
            if(input <= max)
                sb.append("DA\n");
            else
                sb.append("NE\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
