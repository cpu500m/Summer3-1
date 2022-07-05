package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int loop_count = Integer.parseInt(br.readLine());
        int repeat_count;
        String str;
        for(int i = 0 ; i < loop_count ; i++){
            sb.setLength(0);
            st= new StringTokenizer(br.readLine());
            repeat_count = Integer.parseInt(st.nextToken());
            str = st.nextToken();
            for(int j = 0 ; j < str.length() ; j++){
                for(int k = 0 ; k < repeat_count; k++)
                    sb.append(str.charAt(j));
            }
            bw.write(sb.toString()+"\n");
        }
        bw.flush();
    }
}
