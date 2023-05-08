package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_4880 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a,b,c;
        StringBuilder sb = new StringBuilder();
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if(a == 0 && b== 0 && c==0) break;
            int diff1 = b-a , diff2 = c-b;
            if(diff1 == diff2) sb.append("AP "+(c+diff1)+"\n");
            else sb.append("GP "+(c*(c/b))+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
