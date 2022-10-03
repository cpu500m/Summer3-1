package Bronze;

import java.io.*;

public class B3_2411 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb =new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int j;
        for(int i = N ; i > 0 ; i--){
            j = i;
            for(int k = j ; k < N ; k++)
                sb.append(" ");
            for(int k = N - j; k < N ; k++ )
                sb.append("*");
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
