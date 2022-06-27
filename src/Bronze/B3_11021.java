/* 2022-06-27 */
package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_11021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int loop_count = Integer.parseInt(br.readLine());
        for(int i = 1 ; i < loop_count+1; i++){
            st = new StringTokenizer(br.readLine());
            bw.write("Case #"+i+": "+(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken()))+"\n");
        }
        bw.flush();
    }
}
