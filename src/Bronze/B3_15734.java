package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_15734 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int sub = Integer.parseInt(st.nextToken());
        while (sub != 0){
            if(l < r)
                l++;
            else r++;
            sub--;
        }
        int res = 2* ( l <r ? l : r);
        bw.write(String.valueOf(res));
        bw.flush();
    }
}
