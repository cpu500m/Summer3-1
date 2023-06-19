package Bronze;

import java.io.*;

public class B4_17863 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine().substring(0,3);
        if(str.equals("555"))
            bw.write("YES");
        else bw.write("NO");
        bw.flush();
    }
}
