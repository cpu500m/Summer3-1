package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        String com1 = st.nextToken();
        String com2 = st.nextToken();
        int c1 ,c2;
        for(int i = com1.length()-1 ; i >= 0 ; i--){
            sb.append(com1.charAt(i));
        }
        c1 = Integer.parseInt(sb.toString());
        sb.setLength(0);
        for(int j = com2.length()-1 ; j >= 0 ; j--){
            sb.append(com2.charAt(j));
        }
        c2 = Integer.parseInt(sb.toString());
        if( c1 >= c2)
            bw.write(String.valueOf(c1));
        else
            bw.write(String.valueOf(c2));
        bw.flush();
    }
}
