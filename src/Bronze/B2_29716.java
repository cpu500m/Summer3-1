package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_29716 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int j = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int result = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int score  = 0;
            for (int k = 0; k < str.length(); k++) {
                char c = str.charAt(k);
                if ('A' <= c && c <= 'Z')
                    score += 4;
                else if( c == ' ')
                    score+= 1;
                else score+= 2;

                if(score > j)
                    break;
            }
            if(score <= j)
                result++;
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
