package Bronze;

import java.io.*;

public class B5_2558 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(Integer.parseInt(br.readLine())+Integer.parseInt(br.readLine())));
        bw.flush();
    }
}
