package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B4_30008 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] rank = new int[k];
        for (int i = 0; i < k; i++) {
            rank[i] = Integer.parseInt(st.nextToken());
        }

        logic(sb, n, k, rank);
        bw.write(sb.toString());
        bw.flush();
    }

    private static void logic(StringBuilder sb, int n, int k, int[] rank) {
        for (int i = 0; i < k; i++) {
            int p = (rank[i] * 100) / n;
            int s = -1;
            if(96 < p) s = 9;
            else if( 89< p) s= 8;
            else if(77< p) s= 7;
            else if( 60< p) s=6;
            else if( 40< p) s=5;
            else if( 23< p) s=4;
            else if( 11< p) s=3;
            else if( 4< p) s= 2;
            else  s= 1;
            sb.append(s + " ");
        }
    }
}
