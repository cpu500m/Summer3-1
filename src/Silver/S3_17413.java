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
 * @fileName : S3_17413
 * @date : 25. 5. 2.
 */
public class S3_17413 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        StringBuilder sb = new StringBuilder();

        int curIdx = 0;
        while (curIdx < str.length()) {
            if(str.charAt(curIdx) == '<'){
                while (str.charAt(curIdx) != '>'){
                    sb.append(str.charAt(curIdx));
                    curIdx++;
                }
                sb.append(str.charAt(curIdx++));
                continue;
            }

            StringBuilder tempSb = new StringBuilder();
            while(curIdx < str.length() && (str.charAt(curIdx) != ' ' && str.charAt(curIdx) != '<' )){
                tempSb.append(str.charAt(curIdx));
                curIdx++;
            }
            sb.append(tempSb.reverse());

            while(curIdx < str.length() && str.charAt(curIdx) == ' '){
                sb.append(str.charAt(curIdx++));
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
