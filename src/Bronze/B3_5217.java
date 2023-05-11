package Bronze;

import java.io.*;

public class B3_5217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n;  i++){
            int k = Integer.parseInt(br.readLine());
            sb.append("Pairs for "+k+": ");
            if( k >2){
                sb.append("1 "+ (k-1));
            }
            for(int j = 2 ; j < k-j ; j++){
                sb.append(", "+ j+" "+(k-j));
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
