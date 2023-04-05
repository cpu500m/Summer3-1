package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_10801 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int a_c = 0 , b_c =0;
        for(int i = 0 ; i < 10 ; i++){
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            if( a > b) a_c++;
            else if(a < b) b_c++;
        }
        if(a_c > b_c) bw.write("A");
        else if(a_c < b_c) bw.write("B");
        else bw.write("D");
        bw.flush();
    }
}
