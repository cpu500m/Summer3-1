package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_3009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int x =Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        boolean x_f = false , y_f = false , oooo = false;
        int a = 0, s = 0;
        int x2 = -1 , y2 = -1;
        for(int i = 0 ; i < 2; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            if( x2 == a) {
                sb.append(x + " ");
                x_f = true;
            }
            if( y2 == s) {
                oooo= true;
                y_f= true;
            }
            if( a != x)
                x2 = a;
            if( s != y)
                y2 = s;
        }
        if(!x_f)
            sb.append(x2+" ");
        if(!y_f)
            sb.append(y2);
        if(oooo)
            sb.append(y);
        bw.write(sb.toString());
        bw.flush();
    }
}
