package Bronze;

import java.io.*;

public class B3_10995 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringBuilder sub_sb = new StringBuilder();

        sub_sb.append("*");
        for(int i = 1 ; i < n ; i++){
            sub_sb.append(" *");
        }
        for(int i = 1 ; i <= n ; i++) {
            if( i % 2 == 0)
                sb.append(" ");
            sb.append(sub_sb.toString() + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
