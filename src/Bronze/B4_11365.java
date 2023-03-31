package Bronze;

import java.io.*;

public class B4_11365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String str;
        while (!(str=br.readLine()).equals("END")){
            sb.append(str);
            sb = sb.reverse();
            bw.write(sb.toString()+"\n");
            sb.setLength(0);
        }
        bw.flush();
    }
}
