package Silver;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class S3_11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Set<String> com = new HashSet<>();
        String str = br.readLine();
        for(int i = 0 ; i< str.length(); i++){
            for(int j = i ; j < str.length() ; j++){
                sb.append(str.charAt(j));
                com.add(sb.toString());
            }
            sb.setLength(0);
        }
        bw.write(String.valueOf(com.size()));
        bw.flush();
    }
}
