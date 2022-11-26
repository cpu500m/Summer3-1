package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S5_5347 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        long i, a, b;
        StringTokenizer st;
        for(i = 0 ; i< n ; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            sb.append(String.valueOf((a*b)/gcd(a,b))+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    static long gcd(long a , long b){
        long temp;
        if( a<b){
            temp = a;
            a = b;
            b = temp;
        }
        while(b!=0){
            temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }
}
