package Bronze;

import java.io.*;

public class B4_2440 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i = N ; i > 0; i--) {
            for (int j = i; j > 0 ; j--)
                sb.append("*");
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
