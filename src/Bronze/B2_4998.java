package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_4998 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        StringTokenizer st;
        int cnt;
        StringBuilder sb = new StringBuilder();
        double N,B,M;
        while((str = br.readLine()) != null){
            cnt = 0 ;
            st = new StringTokenizer(str);
            N = Double.parseDouble(st.nextToken());
            B =  Double.parseDouble(st.nextToken());
            M = Double.parseDouble(st.nextToken());;
            while(N <= M){
                N = N+(N/100)*B;
                cnt++;
            }
            sb.append(cnt+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
