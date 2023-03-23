package Bronze;

import java.io.*;

public class B1_11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        char c;
        for(int i = 0 ; i < str.length() ; i++){
            c = str.charAt(i);
            if('a' <= c && c <= 'z'){
                c = (char)(str.charAt(i) + 13);
                if( c > 'z'){
                    c = (char)('a'+ (c-'z')-1);
                }
            }
            else if('A' <= c && c <= 'Z'){
                c = (char)(str.charAt(i) + 13);
                if( c > 'Z'){
                    c = (char)('A'+ (c-'Z')-1);
                }
            }
            sb.append(c);
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
