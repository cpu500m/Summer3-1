// 1 , 6, 12, 18 ...
package Bronze;

import java.io.*;

public class B2_2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int level = 1;
        int room = 1;
        int increase = 0;
        while(n > level){
            increase+=6;
            level+=increase;
            room++;
        }
        bw.write(String.valueOf(room));
        bw.flush();
    }
}
