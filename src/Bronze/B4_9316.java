package Bronze;

import java.io.*;

public class B4_9316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= N ; i++){
            sb.append("Hello World, Judge "+i+"!\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
