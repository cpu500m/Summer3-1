package Silver;

import java.io.*;

public class S4_1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        String search = br.readLine();
        String sub_string;
        int result = 0;
        int i;
        for( i = 0 ; i <str.length() - search.length()+1;) {
            sub_string = str.substring(i,i+search.length());
            if(sub_string.equals(search)) {
                result++;
                i+= sub_string.length();
                continue;
            }
            i++;
        }
        bw.write(String.valueOf(result));
        bw.flush();

    }
}
