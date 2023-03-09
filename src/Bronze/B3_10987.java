package Bronze;

import java.io.*;

public class B3_10987 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int res = 0;
        for(int i = 0 ; i < str.length() ; i++){
            char c = str.charAt(i);
            if(c == 'a' || c== 'e' || c =='i' || c == 'o' || c== 'u')
                res++;
        }
        bw.write(String.valueOf(res));
        bw.flush();
    }
}
