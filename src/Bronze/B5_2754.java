package Bronze;

import java.io.*;

public class B5_2754 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String score = br.readLine();
        double s = 4-(score.charAt(0)-'A');
        if(s > 0) {
            char c = score.charAt(1);
            if (c == '+') s += 0.3;
            else if (c == '-') s -= 0.3;
        }
        else s = 0;
        bw.write(String.valueOf(s));
        bw.flush();
    }
}
