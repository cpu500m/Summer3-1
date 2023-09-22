package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B4_30017 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if( a <= b){
            bw.write(String.valueOf(2*a-1));
        }
        else if(a > b){
            bw.write(String.valueOf(2*b+1));
        }
        bw.flush();
    }
}
