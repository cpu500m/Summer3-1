package Bronze;

import java.io.*;

public class B3_3053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int radius = Integer.parseInt(br.readLine());
        sb.append(Math.round((radius*radius*Math.PI)*100000)/ 100000.0+"\n");
        sb.append(radius*radius*2);
        bw.write(sb.toString());
        bw.flush();
    }
}
