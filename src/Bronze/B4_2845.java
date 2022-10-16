package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B4_2845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken())*Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i <5; i++){
            sb.append(Integer.parseInt(st.nextToken())-N+" ");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
