package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_1681 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int cur = 0;
        String L = st.nextToken();
        for(int i = 0; i < N ; ){
            cur++;
            if(!String.valueOf(cur).contains(L))
                i++;
        }
        bw.write(String.valueOf(cur));
        bw.flush();
    }
}
