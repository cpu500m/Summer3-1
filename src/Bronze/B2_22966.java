package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_22966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int min= 5;
        String temp = "a";
        for(int i =0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int level = Integer.parseInt(st.nextToken());
            if(level < min) {
                min= level;
                temp = str;
            }
        }
        bw.write(temp);
        bw.flush();
    }
}
