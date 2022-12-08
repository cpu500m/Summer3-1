package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B4_5717 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st =new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int sum= Integer.parseInt(st.nextToken())+ Integer.parseInt(st.nextToken());
        while(sum != 0){
            sb.append(sum+"\n");
            st = new StringTokenizer(br.readLine());
            sum = Integer.parseInt(st.nextToken())+ Integer.parseInt(st.nextToken());
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
