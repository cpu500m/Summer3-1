package Bronze;

import java.io.*;

public class B5_2744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String str= br.readLine();
        for(int i = 0 ; i < str.length() ; i++){
            if('a' <= str.charAt(i) && str.charAt(i) <= 'z')
                sb.append(Character.toUpperCase(str.charAt(i)));
            else sb.append(Character.toLowerCase(str.charAt(i)));
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
