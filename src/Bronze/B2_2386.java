package Bronze;

import java.io.*;

public class B2_2386 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] str;
        while (true) {
            str = br.readLine().split(" ");
            char c = Character.toLowerCase(str[0].charAt(0));
            int cnt = 0;
            if(c == '#') break;
            for (int i = 1; i < str.length; i++) {
                String temp = str[i].toLowerCase();
                for (int j = 0; j < temp.length(); j++) {
                    if(temp.charAt(j) == c)
                        cnt++;
                }
            }
            sb.append(c+" "+cnt + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
