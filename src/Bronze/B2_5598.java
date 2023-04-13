package Bronze;

import java.io.*;

public class B2_5598 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < str.length() ; i++){
            char c = (char)(str.charAt(i)-3);
            if(c < 'A')
                c += 26;
            sb.append(c);
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
