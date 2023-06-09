package Bronze;

import java.io.*;

public class B5_24568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(Integer.parseInt(br.readLine()) * 8 + Integer.parseInt(br.readLine()) * 3 - 28));
        bw.flush();

    }
}
