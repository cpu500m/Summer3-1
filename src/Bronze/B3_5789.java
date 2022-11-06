package Bronze;

import java.io.*;

public class B3_5789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String str;
        int mid;
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++) {
            str = br.readLine();
            mid = str.length()/2;
            if (str.charAt(mid-1) == str.charAt(mid))
                sb.append("Do-it\n");
            else
                sb.append("Do-it-Not\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
