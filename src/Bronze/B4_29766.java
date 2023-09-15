package Bronze;

import java.io.*;

public class B4_29766 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        String comp = "DKSH";
        int cur = 0;
        int res= 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == comp.charAt(cur))
                cur++;
            else{
                if(str.charAt(i) == 'D')
                    cur = 1;
                else cur = 0;
            }
            if (cur == comp.length()) {
                res++;
                cur = 0;
            }
        }
        bw.write(String.valueOf(res));
        bw.flush();
    }
}
