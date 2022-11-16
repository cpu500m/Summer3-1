package Bronze;

import java.io.*;

public class B4_4470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= n ; i++) {
            sb.append(String.valueOf(i)+". "+br.readLine()+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
