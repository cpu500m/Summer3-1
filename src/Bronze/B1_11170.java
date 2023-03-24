package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B1_11170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        int s, e;
        for(int tc = 1 ; tc <= TC ; ++tc){
            StringTokenizer st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            int cnt = 0;
            for(int i = s ; i <= e ; i++){
                String str = String.valueOf(i);
                for(int j = 0 ; j < str.length() ; j++){
                    if(str.charAt(j) == '0') cnt++;
                }
            }
            sb.append(cnt+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
