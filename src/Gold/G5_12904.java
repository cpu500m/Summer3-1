package Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author : paulkim
 * @description :
 * @packageName : Gold
 * @fileName : G5_12904
 * @date : 25. 4. 27.
 */
public class G5_12904 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String t = br.readLine();

        while(s.length() < t.length()){
            StringBuilder sb = new StringBuilder(t.substring(0,t.length()-1));
            char c = t.charAt(t.length() - 1);
            if(c == 'A'){
                t = sb.toString();
            } else{
                t = sb.reverse().toString();
            }
        }

        if(s.equals(t)){
            bw.write("1");
        } else{
            bw.write("0");
        }
        bw.flush();
    }
}
