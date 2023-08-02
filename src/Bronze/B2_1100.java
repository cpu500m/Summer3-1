package Bronze;

import java.io.*;

public class B2_1100 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int res = 0;
        for (int i = 0; i < 8; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == 'F' && (i+j) % 2 == 0)
                    res++;
            }
        }
        bw.write(String.valueOf(res));
        bw.flush();
    }
}
