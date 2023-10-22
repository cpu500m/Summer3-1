package Silver;

import java.io.*;

public class S5_4335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n ;
        int min=0 , max= 11;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            String str = br.readLine();
            if(str.equals("too high")){
                max = max > n ? n : max;
            }
            else if(str.equals("too low")){
                min = min < n ? n : min;
            }else{
                if(min < n && n < max) sb.append("Stan may be honest\n");
                else sb.append("Stan is dishonest\n");
                min=0; max= 11;
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
