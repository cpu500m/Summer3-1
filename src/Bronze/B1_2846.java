package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B1_2846 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cur_total = 0;
        int res = 0;
        int pre = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i < n ; i++){
            int cur = Integer.parseInt(st.nextToken());
            if(cur <= pre){
                if(res < cur_total)
                    res = cur_total;
                cur_total = 0;
            }
            else cur_total += (cur - pre);

            pre = cur;
        }
        if(res < cur_total)
            res = cur_total;
        bw.write(String.valueOf(res));
        bw.flush();
    }
}
