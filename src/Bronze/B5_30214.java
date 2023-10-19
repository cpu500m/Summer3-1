package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B5_30214 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        if(Integer.parseInt(st.nextToken()) >= (Integer.parseInt(st.nextToken())+1)/2)
            bw.write("E");
        else bw.write("H");
        bw.flush();
    }
}
