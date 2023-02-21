package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B5_23514 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i <N/4; i++){
            sb.append("long ");
        }
        sb.append("int");
        bw.write(sb.toString());
        bw.flush();
    }
}
