package Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author : paulkim
 * @description :
 * @packageName : Silver
 * @fileName : S5_1439
 * @date : 25. 5. 2.
 */
public class S5_1439 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();

        char c = str.charAt(0);
        int[] groupCnt = new int[2];
        groupCnt[c-'0']++;

        char curC = c;

        for (int i = 1; i < str.length(); i++) {
            c = str.charAt(i);
            if(c == curC) continue;

            groupCnt[c-'0']++;
            curC = c;
        }
        bw.write(String.valueOf(groupCnt[0] > groupCnt[1] ? groupCnt[1] : groupCnt[0]));
        bw.flush();
    }
}
