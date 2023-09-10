package Bronze;

import java.io.*;

public class B3_29713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] cnt = new int[26];
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String comp = "BRONZESILVER";
        for (int i = 0; i < n; i++) {
            cnt[str.charAt(i)-'A']++;
        }
        int result = 0;
        boolean exit_flag = true;
        while (exit_flag){
            for (int i = 0; i < comp.length(); i++) {
                int idx = comp.charAt(i) - 'A';
                if (cnt[idx] > 0)
                    cnt[idx]--;
                else {
                    exit_flag = false;
                    break;
                }
            }
            if(exit_flag)
                result++;
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
