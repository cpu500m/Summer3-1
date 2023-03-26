package Bronze;

import java.io.*;

public class B3_3460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int tc = 1 ; tc <= TC ; ++tc){
            int n = Integer.parseInt(br.readLine());
            for(int i = 0 ; i < 31 ; i++){
                if( ((1<<i) & n) != 0)
                    sb.append(i+" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
