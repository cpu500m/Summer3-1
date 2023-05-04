package Bronze;

import java.io.*;

public class B3_10102 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int[] cnt = new int[2];
        for(int i = 0 ; i < n ; i++)
            cnt[str.charAt(i)-'A']++;
        if(cnt[0] > cnt[1])
            bw.write("A");
        else if(cnt[0] < cnt[1])
            bw.write("B");
        else bw.write("Tie");
        bw.flush();
    }
}
