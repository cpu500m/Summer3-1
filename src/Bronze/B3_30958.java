package Bronze;

import java.io.*;

public class B3_30958 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int SIZE = 26;
        int[] cnt = new int[SIZE];
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if( 'a' <= c && c <= 'z')
                cnt[c-'a']++;
        }
        int max = 0;
        for (int i = 0; i < SIZE; i++) {
            if(max < cnt[i])
                max = cnt[i];
        }
        bw.write(String.valueOf(max));
        bw.flush();
    }
}
