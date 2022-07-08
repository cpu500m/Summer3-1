package Bronze;

import java.io.*;

public class B1_11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        divideN(N);
    }
    public static void divideN(int N) throws IOException {
        int divisor = 2;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (divisor <= N) {
            if (N % divisor == 0) {
                N /= divisor;
                bw.write(String.valueOf(divisor)+"\n");
            }
            else
                divisor++;
        }
        bw.flush();
    }
}
