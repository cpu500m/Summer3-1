package Bronze;

import java.io.*;

public class B5_9086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            sb.append(str.charAt(0));
            sb.append(str.charAt(str.length()-1)+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
