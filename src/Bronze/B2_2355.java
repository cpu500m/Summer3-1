package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_2355 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long sum = 0;
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long temp = a;
        a = Math.min(a,b);
        b = Math.max(temp ,b);
        long len = (b-a)+1;
        if(len < 1)
            return;
        if( len%2 == 0){
            sum=(a+b)*(len/2);
        }
        else{
            sum = (a+b)*(len/2)+((a+b)/2);
        }
        bw.write(String.valueOf(sum));
        bw.flush();
    }
}
