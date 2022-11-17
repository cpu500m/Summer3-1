package Bronze;

import java.io.*;

public class B5_6810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n;
        int sum = 91;
        for (int i = 0; i < 3; i++) {
            n = Integer.parseInt(br.readLine());
            if (i % 2 == 0)
                sum += (n * 1);
            else
                sum += (n * 3);
        }
        bw.write("The 1-3-sum is "+String.valueOf(sum));
        bw.flush();
    }
}
