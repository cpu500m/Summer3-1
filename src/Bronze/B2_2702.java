package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_2702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int a , b, k;
        for(int i = 0 ; i < count ; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            k = gcd(a,b);
            sb.append((a*b)/k+" "+k+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    static int gcd(int a , int b){
       int temp;
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
