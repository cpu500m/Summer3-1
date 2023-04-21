package Bronze;

import java.io.*;

public class B2_10173 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String str;
        while (!(str = br.readLine()).equals("EOI")){
            str = str.toUpperCase();
            if(str.contains("NEMO"))
                sb.append("Found\n");
            else sb.append("Missing\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
