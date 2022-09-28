package Bronze;

import java.io.*;

public class B2_2154 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= N; i++){
            sb.append(i);
        }
        bw.write(String.valueOf(sb.indexOf(String.valueOf(N))+1));
        bw.flush();
    }
}
