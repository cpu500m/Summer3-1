package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int x =Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int min;
        if( x - 0 > Math.abs(w-x))
            min = Math.abs(w-x);
        else
            min = x-0;
        if(y - 0 < min)
            min = y-0;
        if(Math.abs(h-y) < min)
            min = Math.abs(h-y);
        bw.write(String.valueOf(min));
        bw.flush();
    }
}
