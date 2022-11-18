package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B5_3733 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n,s;
        while( (str = br.readLine()) != null){
        st = new StringTokenizer(str);
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        sb.append(String.valueOf(s / (n+1))+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
