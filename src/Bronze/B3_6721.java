package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_6721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int i, a, b;
        int n = Integer.parseInt(br.readLine());
        for(i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            a = getReverseValue(st.nextToken());
            b = getReverseValue(st.nextToken());
            sb.append(String.valueOf(getReverseValue(String.valueOf(a+b)))+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    public static int getReverseValue(String str){
        int value =0, i;
        int cur = 1;
        for(i = 0; i< str.length() ; i++){
            value += (str.charAt(i)-'0')*cur;
            cur*=10;
        }
        return value;
    }
}
