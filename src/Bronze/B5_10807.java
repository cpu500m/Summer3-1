package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B5_10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        String target = br.readLine();
        int ans = 0;
        for(int i = 0 ; i < N ; i++){
            if(target.equals(st.nextToken())) ans++;
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
