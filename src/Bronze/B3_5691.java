package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_5691 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int temp;
        StringBuilder sb = new StringBuilder();
        while ( a !=0 || b !=0){
            if(a > b){
                temp = a;
                a = b;
                b = temp;
            }
            sb.append( String.valueOf(a-(b-a))+"\n");
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
