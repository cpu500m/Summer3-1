package Bronze;

import java.io.*;

public class B3_30684 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String str = "ZZZ";
        for (int i = 0; i < n; i++) {
            String cur = br.readLine();
            if(cur.length() != 3) continue;
            if(str.compareTo(cur) > 0) str = cur;
        }
        bw.write(str);
        bw.flush();
    }
}
