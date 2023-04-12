package Bronze;

import java.io.*;

public class B2_2789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        boolean[] check = new boolean[26];
        String standard = "CAMBRIDGE";
        for(int i = 0 ; i <standard.length() ; i++)
            check[standard.charAt(i)-'A'] =true;
        for(int i = 0 ; i < str.length() ; i++)
            if(!check[str.charAt(i)-'A'])
                sb.append(str.charAt(i));
        bw.write(sb.toString());
        bw.flush();
    }
}
