package Bronze;

import java.io.*;

public class B2_3028 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int i;
        int cur = 1;
        char c;
        for(i = 0; i < str.length() ; i++){
            c = str.charAt(i);
            if( c == 'A'){
                if(cur == 1)
                    cur = 2;
                else if(cur == 2)
                    cur = 1;
            }
            else if (c == 'B'){
                if(cur == 2)
                    cur = 3;
                else if(cur == 3)
                    cur = 2;
            }
            else if (c == 'C'){
                if(cur == 1)
                    cur = 3;
                else if(cur == 3)
                    cur = 1;
            }
        }
        bw.write(String.valueOf(cur));
        bw.flush();
    }
}
