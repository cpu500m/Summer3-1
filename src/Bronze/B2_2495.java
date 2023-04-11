package Bronze;

import java.io.*;

public class B2_2495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            String str = br.readLine();
            int max = 1;
            int cur = 1;
            char c = str.charAt(0);
            for (int j = 1; j < str.length(); j++) {
                if (c == str.charAt(j)) {
                    cur++;
                    if(max < cur)
                        max = cur;
                }
                else {
                    c = str.charAt(j);
                    cur = 1;
                }
            }
            sb.append(max+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
