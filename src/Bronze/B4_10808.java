package Bronze;

import java.io.*;

public class B4_10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int[] cnt = new int[26];
        String str = br.readLine();
        for(int i = 0 ; i < str.length() ; i++){
            cnt[str.charAt(i)-'a']++;
        }
        for(int i = 0 ; i < 26; i++)
            sb.append(cnt[i]+" ");
        bw.write(sb.toString());
        bw.flush();
    }
}
