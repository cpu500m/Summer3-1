package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_4084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int cnt, cur;
        int a,b,c,d;
        int[] temp= new int[4];
        while(true){
            st= new StringTokenizer(br.readLine());
            cnt = 0;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            if( a== 0 && b== 0 && c==0 && d==0)
                break;
            cur = a;
            while(b != cur || c != cur || d != cur){
                temp[0] = Math.abs(a-b);
                temp[1] = Math.abs(b-c);
                temp[2] = Math.abs(c-d);
                temp[3] = Math.abs(d-a);
                a = temp[0]; b= temp[1] ; c= temp[2] ; d = temp[3];
                cnt++;
                cur = a;
            }
            sb.append(String.valueOf(cnt)+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
