package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_1009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb =  new StringBuilder();
        int loop_count = Integer.parseInt(br.readLine());
        StringTokenizer st;
        long com;
        int a,b;
        for(int i = 0 ; i < loop_count ; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            com = my_pow(a,b);
            com = (com == 0 ? 10 : com);
            sb.append(com+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    private static long my_pow(int a, int b){
        if(b == 1)
            return (a %10);
        long temp = my_pow(a,b/2) %10;
        if( b %2 == 0)
            return (temp*temp)%10;
        else
            return (temp*temp*a)%10;
    }
}
