package Bronze;

import java.io.*;

public class B2_2902 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        for(int i = 1; i < str.length();i++){
            if(str.charAt(i) == '-')
                sb.append(str.charAt(i+1));
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
