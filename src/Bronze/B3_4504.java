package Bronze;

import java.io.*;

public class B3_4504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N= Integer.parseInt(br.readLine());
        int t;
        while ( (t=Integer.parseInt(br.readLine())) != 0){
            if( t % N ==0)
                sb.append(t+" is a multiple of "+N+".\n");
            else sb.append(t+" is NOT a multiple of "+N+".\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
