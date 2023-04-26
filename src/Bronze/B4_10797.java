package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B4_10797 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int res = 0;
        for(int i = 0 ; i < 5 ; i++){
            if(Integer.parseInt(st.nextToken()) == n)
                res++;
        }
        bw.write(String.valueOf(res));
        bw.flush();
    }
}
