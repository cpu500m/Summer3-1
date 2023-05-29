package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_11367 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int i = 0; i < TC; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append(st.nextToken()+" ");
            String score = st.nextToken();
            if(score.charAt(0) == '9') {
                sb.append("A");
            }
            else if(score.charAt(0)== '8')
                sb.append("B");
            else if(score.charAt(0)== '7')
                sb.append("C");
            else if(score.charAt(0)== '6')
                sb.append("D");
            else if(score.length() == 3) {
                sb.append("A+\n");
                continue;
            }
            else{
                sb.append("F\n");
                continue;
            }
            char c = score.charAt(1);
            if( c-'7' < 0) sb.append("\n");
            else sb.append("+\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
