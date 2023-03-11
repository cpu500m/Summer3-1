package Bronze;

import java.io.*;

public class B3_2490 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i <3 ; i++){
            String[] c = br.readLine().split(" ");
            int cnt = 0;
            for(String s : c){
                if(s.equals("0"))
                    cnt++;
            }
            if( cnt <= 4 && cnt != 0)
                sb.append((char)('A'+cnt-1)+"\n");
            else sb.append("E\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
