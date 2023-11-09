package Bronze;

import java.io.*;

public class B3_15894 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        // 1층이 늘어날 때 마다
        // 세로길이 2 늘어나고
        // 가로길이 2 늘어나네
        // 걍 *4?
        bw.write(String.valueOf((long)n*4));
        bw.flush();
    }
}
