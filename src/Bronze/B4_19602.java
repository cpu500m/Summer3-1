package Bronze;

import java.io.*;

public class B4_19602 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int val = Integer.parseInt(br.readLine())
                + Integer.parseInt(br.readLine()) * 2 + Integer.parseInt(br.readLine())*3;
        bw.write(val >= 10 ? "happy" : "sad");
        bw.flush();
    }
}

