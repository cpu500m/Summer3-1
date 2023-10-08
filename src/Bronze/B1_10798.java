package Bronze;

import java.io.*;

public class B1_10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] str = new String[5];
        int max = 0;
        for (int i = 0; i < 5; i++) {
            String temp = br.readLine();
            if (temp.length() > max) {
                max = temp.length();
            }
            str[i] = temp;
        }

        int cnt = 0;
        while (cnt < max) {
            for (int i = 0; i < 5; i++) {
                if(cnt >= str[i].length())
                    continue;
                sb.append(str[i].charAt(cnt));
            }
            cnt++;
        }
        bw.write(sb.toString());
        bw.flush();
    }

}
