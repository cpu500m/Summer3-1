package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_5523 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int a_c = 0, b_c= 0 ;
        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if( a > b)
                a_c++;
            else if( a< b)
                b_c++;
        }
        bw.write(a_c+" "+b_c);
        bw.flush();
    }
}
