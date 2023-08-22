package Bronze;

import java.io.*;

public class B4_1264 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str;
        while (!(str = br.readLine()).equals("#")) {
            int val = 0;
            str = str.toLowerCase();
            for (int i = 0; i < str.length(); i++) {
                switch (str.charAt(i)) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                        val++;
                }
            }
            sb.append(val + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
