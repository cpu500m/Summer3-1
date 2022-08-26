package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B5_10869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B =Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        sb.append( (A+B)+"\n");
        sb.append((A-B)+"\n");
        sb.append((A*B)+"\n");
        sb.append((A/B)+"\n");
        sb.append((A%B));
        bw.write(sb.toString());
        bw.flush();
    }
}
