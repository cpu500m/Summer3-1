package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_1773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        boolean[] check = new boolean[C+1];
        int cur;
        int cnt = 0;
        for(int i = 0; i < N ; i++){
            cur = Integer.parseInt(br.readLine());
            for(int k = cur ; k <= C ; k+=cur){
                if(!check[k]) {
                    check[k] = true;
                    cnt++;
                }
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}
