package Bronze;

import java.io.*;

public class B2_10821 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = br.readLine().split(",");
        bw.write(String.valueOf(arr.length));
        bw.flush();
    }
}
