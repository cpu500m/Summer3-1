package Bronze;

import java.io.*;

public class B2_2774 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        for(int tc = 1 ; tc <= TC ; ++tc){
            int cnt = 0;
            boolean[] check = new boolean[10];
            String str = br.readLine();
            for (int i = 0 ; i <str.length() ; i++) {
                char c = str.charAt(i);
                if(!check[c-'0']) {
                    check[str.charAt(i) - '0'] = true;
                    cnt++;
                }
            }
            sb.append(cnt+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
