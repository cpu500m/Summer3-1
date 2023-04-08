package Bronze;

import java.io.*;

public class B2_10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String str;
        while( (str= br.readLine()) != null){
            int[] cnt = new int[4];
            for(int i = 0 ; i < str.length(); i++){
                char c = str.charAt(i);
                if('a' <= c && c <= 'z') cnt[0]++;
                else if('A' <= c && c <= 'Z') cnt[1]++;
                else if('0' <= c && c <= '9') cnt[2]++;
                else cnt[3]++;
            }
            for(int i = 0 ; i <4 ; i++)
            sb.append(cnt[i]+" ");
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
