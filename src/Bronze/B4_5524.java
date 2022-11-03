package Bronze;

import java.io.*;

public class B4_5524 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String str;
        StringBuilder sb = new StringBuilder();
        for(int i =0; i < N ;i++){
            str = br.readLine();
            sb.append(str.toLowerCase()+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
