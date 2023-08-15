package Bronze;

import java.io.*;

public class B1_10769 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int happy_cnt = countString(str, ":-)");
        int sad_cnt = countString(str, ":-(");
        bw.write(decideFeeling(happy_cnt,sad_cnt));
        bw.flush();
    }
    private static int countString(String str , String pattern) {
        int cnt = 0;
        int cur = 0;
        for (int i = 0; i < str.length(); i++) {
            if (pattern.charAt(cur) == str.charAt(i)) {
                cur++;
                if (cur == pattern.length()) {
                    cnt++;
                    cur = 0;
                }
            }
        }
        return cnt;
    }
    private static String decideFeeling(int happy_cnt , int sad_cnt) {
        if(happy_cnt > sad_cnt)
            return "happy";
        else if (happy_cnt < sad_cnt)
            return "sad";
        else if(happy_cnt == 0 && sad_cnt == 0)
            return "none";
        else return "unsure";
    }
}
