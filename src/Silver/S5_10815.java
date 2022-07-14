package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S5_10815 {
    private static final int MAX = 10_000_000;
    public static void main(String[] args) throws IOException {
        boolean[] cards= new boolean[MAX*2+1];
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            cards[Integer.parseInt(st.nextToken())+MAX] = true;
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M; i ++) {
            if (cards[Integer.parseInt(st.nextToken()) + MAX] == true)
                sb.append("1 ");
            else
                sb.append("0 ");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
