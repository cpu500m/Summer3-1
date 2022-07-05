package Bronze;

import java.io.*;

public class B5_11654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
        char c = br.readLine().charAt(0);
        pw.printf("%d", (int)c);
        pw.flush();
    }
}
