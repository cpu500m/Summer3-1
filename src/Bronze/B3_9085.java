package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_9085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        for(int tc = 1 ; tc <= TC ; ++tc){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
            for(int i= 0 ; i < N ; i++){
                sum += Integer.parseInt(st.nextToken());
            }
            sb.append(sum+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
