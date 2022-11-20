package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_5612 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int cur = Integer.parseInt(br.readLine());
        int max = cur;
        StringTokenizer st;
        for(int i = 0; i< n ; i++){
            st = new StringTokenizer(br.readLine());
            cur += Integer.parseInt(st.nextToken());
            cur -= Integer.parseInt(st.nextToken());
            if(cur < 0){
                max = 0;
                break;
            }
            if(cur > max)
                max = cur;
        }
        bw.write(String.valueOf(max));
        bw.flush();
    }
}
