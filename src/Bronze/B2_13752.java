package Bronze;

import java.io.*;

public class B2_13752 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N ; i++){
            int cnt = Integer.parseInt(br.readLine());
            for(int j = 0 ; j < cnt; j++)
                sb.append("=");
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
