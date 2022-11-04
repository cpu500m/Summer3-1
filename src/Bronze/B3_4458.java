package Bronze;

import java.io.*;

public class B3_4458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String str;
        for(int i = 0; i <N ; i++) {
            str = br.readLine();
            sb.append(Character.toUpperCase(str.charAt(0)));
            for(int j = 1; j < str.length() ;j++)
                sb.append(str.charAt(j));
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
