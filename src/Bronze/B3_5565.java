package Bronze;

import java.io.*;

public class B3_5565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < 9 ; i++)
            total -= Integer.parseInt(br.readLine());
        bw.write(String.valueOf(total));
        bw.flush();
    }
}
