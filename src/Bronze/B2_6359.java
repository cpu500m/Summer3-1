package Bronze;

import java.io.*;

public class B2_6359 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int[] cnt = new int[101];
        for(int i = 1 ; i < cnt.length  ; i++)
            for(int j = i ; j < cnt.length ; j+=i)
                cnt[j]++;

        int TC = Integer.parseInt(br.readLine());
        for(int tc = 1 ; tc <= TC ; ++tc){
            int n = Integer.parseInt(br.readLine());
            int res = 0;
            for(int i = 1 ; i <= n ; i++)
                if(cnt[i] % 2 == 1) res++;
            sb.append(res+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
